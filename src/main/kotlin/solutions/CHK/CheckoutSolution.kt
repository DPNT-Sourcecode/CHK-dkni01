package solutions.CHK

/**
 * Calculate price of items, including special offers.
 */
object CheckoutSolution {
    private val prices = hashMapOf(
    "A" to 50,
    "B" to 30,
    "C" to 20,
    "D" to 15,
    "E" to 40,
    "F" to 10,
    "G" to 20,
    "H" to 10,
    "I" to 35,
    "J" to 60,
    "K" to 70,
    "L" to 90,
    "M" to 15,
    "N" to 40,
    "O" to 10,
    "P" to 50,
    "Q" to 30,
    "R" to 50,
    "S" to 20,
    "T" to 20,
    "U" to 40,
    "V" to 50,
    "W" to 20,
    "X" to 17,
    "Y" to 20,
    "Z" to 21
    )

    // each Pair is how many items must be bought to trigger the offer, and special price
    private val multiplesOffers = hashMapOf(
        "A" to listOf(Pair(3, 130), Pair(5, 200)),
        "B" to listOf(Pair(2, 45), null),
        "H" to listOf(Pair(5, 45), Pair(10, 80)),
        "K" to listOf(Pair(2, 120), null),
        "P" to listOf(Pair(5, 200), null),
        "Q" to listOf(Pair(3, 80), null),
        "V" to listOf(Pair(2, 90), Pair(3, 130)),
    )

    // how many items to trigger the offer, and what item you get free
    private val getOneFree = hashMapOf(
        "E" to Pair(2, "B"),
        "F" to Pair(3, "F"),
        "N" to Pair(3, "M"),
        "R" to Pair(3, "Q"),
        "U" to Pair(4, "U")
    )
    
    private val buyAny3OfferPrice = 45

    fun checkout(skus: String): Int {
        if (skus.any { it !in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" }) {
            return -1
        }

        var totalPrice = 0
        
        // calculating get one free (different item)
        var adjustedSkus: String = ""
        
        // NB map.getValue() risks a NoSuchElementException if the key doesn't exist
        // could add try/catch later
        totalPrice += skus.count { it == 'E' } * prices.getValue("E")
        adjustedSkus = removeFreeItems(skus, "E")

        totalPrice += skus.count { it == 'N' } * prices.getValue("N")
        adjustedSkus = removeFreeItems(adjustedSkus, "N")

        totalPrice += skus.count { it == 'R' } * prices.getValue("R")
        adjustedSkus = removeFreeItems(adjustedSkus, "R")
        
        // calculating get one free (same item)
        for (sku in "UF") {
            totalPrice += calculateGetOneFreeSameOffer(
                sku.toString(),
                adjustedSkus.count { it == sku }
            )
        }
        
        // calculating products with discounts for multiple of that item
        for (sku in "ABHKPQV") {
            totalPrice += calculateMultiplesOffer(
                sku.toString(),
                adjustedSkus.count { it == sku }
            )
        }
        
        // calculating buy any 3
        
        
        val countBuyAny3OfferItems = adjustedSkus.count { it in "STXYZ" }

        val leftover = countBuyAny3OfferItems % 3
        val numBuyAny3OfferSets = (countBuyAny3OfferItems - leftover) / 3

        adjustedSkus = calculateBuyAny3Offer(adjustedSkus)

        
        totalPrice += numBuyAny3OfferSets * buyAny3OfferPrice
        
        // calculating basic products (no special offers)
        for (sku in "CDGIJLMOSTWXYZ") {
            totalPrice += adjustedSkus.count { it == sku } * prices.getValue(sku.toString())
        }
        return totalPrice
    }
    
    private fun calculateOffer(
        price: Int,
        total: Int,
        requiredItems: Int,
        offer: Int
    ) : Pair<Int, Int> {
        val leftover = total % (price * requiredItems)
        val reduced = ((total - leftover) / (price * requiredItems)) * offer
        return Pair(reduced, leftover)
    }
    
    private fun calculateGetOneFreeSameOffer(
        sku: String,
        numItems: Int
    ) : Int {
        val requiredItems = getOneFree[sku]
        requiredItems?.let {
            val skuPrice = prices.getValue(sku)
            val total = numItems * skuPrice
            val offer = calculateOffer(
                skuPrice,
                total,
                requiredItems.first,
                1
            )
            return total - (offer.first * skuPrice)
        }
        return 0
    }
    
    private fun calculateMultiplesOffer(
        sku: String,
        numItems: Int
    ) : Int {
        val skuPrice = prices.getValue(sku)
        val lowerOffer = multiplesOffers[sku]?.first()
        val higherOffer = multiplesOffers[sku]?.last()
        
        lowerOffer?.let {
            higherOffer?.let {
                val highOffer = calculateOffer(
                    skuPrice,
                    numItems * skuPrice,
                    higherOffer.first,
                    higherOffer.second
                )
                val lowOffer = calculateOffer(
                    skuPrice,
                    highOffer.second,
                    lowerOffer.first,
                    lowerOffer.second
                )
                return highOffer.first + lowOffer.first + lowOffer.second
            }
            val lowOffer = calculateOffer(
                skuPrice,
                numItems * skuPrice,
                lowerOffer.first,
                lowerOffer.second
            )
            return lowOffer.first + lowOffer.second
        }
        return 0
    }
    
    private fun removeFreeItems(
        skus: String,
        sku: String
    ) : String {
        val skuPrice = prices.getValue(sku)
        val offerDetails = getOneFree[sku]
        
        offerDetails?.let {
            val requiredItems = it.first
            val freeItemSku = it.second.first()
            val offer = calculateOffer(
                skuPrice,
                skus.count { char -> char == sku.first() } * skuPrice,
                requiredItems,
                1
            )
            
            val numberToRemove = offer.first
            return removeFreeItemsFromString(
                skus,
                freeItemSku,
                numberToRemove
            )
        }
        return skus
    }

    private fun removeFreeItemsFromString(
        skus: String,
        skuToRemove: Char,
        howManyToRemove: Int
    ): String {
        val totalRelevantSku = skus.count { it == skuToRemove }
        val adjustedTotal = totalRelevantSku - howManyToRemove
        val deletedSkus: String = skus.replace(skuToRemove.toString(), "")

        if (adjustedTotal < 0) {
            return deletedSkus
        }

        val adjustedSkus = skuToRemove.toString().repeat(adjustedTotal)
        return deletedSkus + adjustedSkus
    }
    
    private fun calculateBuyAny3Offer(
        skus: String
    ) : String {
        val countBuyAny3OfferItems = skus.count { it in "STXYZ" }
        val leftover = countBuyAny3OfferItems % 3
        val numBuyAny3OfferSets = (countBuyAny3OfferItems - leftover) / 3
        if (numBuyAny3OfferSets == 0) {
            return skus
        }

        var updatedSkusNew = skus.replace("S", "")
        updatedSkusNew = updatedSkusNew.replace("T", "")
        updatedSkusNew = updatedSkusNew.replace("X", "")
        updatedSkusNew = updatedSkusNew.replace("Y", "")
        updatedSkusNew = updatedSkusNew.replace("Z", "")
        
        val countS = skus.count { it == 'S' }
        val countT = skus.count { it == 'T' }
        val countX = skus.count { it == 'X' }
        val countY = skus.count { it == 'Y' }
        val countZ = skus.count { it == 'Z' }
        
        val allS = "S".repeat(countS)
        val allT = "T".repeat(countT)
        val allX = "X".repeat(countX)
        val allY = "Y".repeat(countY)
        val allZ = "Z".repeat(countZ)
        
        // products in ascending price order
        val orderedOfferSkus = allX + allS + allT + allY + allZ
        
        
        when (leftover) {
            0 -> return updatedSkusNew
            1 -> {
                updatedSkusNew += orderedOfferSkus[0]
                return updatedSkusNew
            }
            2 -> {
                updatedSkusNew += orderedOfferSkus[0]
                updatedSkusNew += orderedOfferSkus[1]
                return updatedSkusNew
            }
            else -> return updatedSkusNew
        }
    }
}
