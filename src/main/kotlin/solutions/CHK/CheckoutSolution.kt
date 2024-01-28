package solutions.CHK

object CheckoutSolution {
    val prices = hashMapOf(
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
    "K" to 80,
    "L" to 90,
    "M" to 15,
    "N" to 40,
    "O" to 10,
    "P" to 50,
    "Q" to 30,
    "R" to 50,
    "S" to 30,
    "T" to 20,
    "U" to 40,
    "V" to 50,
    "W" to 20,
    "X" to 90,
    "Z" to 50,
    "Y" to 10
    )
    
    const val A_OFFER3 = 130
    const val A_OFFER5 = 200
    const val B_OFFER2 = 45
    
    fun checkout(skus: String): Int {
        if (skus.any { it !in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" }) {
            return -1
        }
        
        var totalPrice = 0
        
//        TODO catch NoSuchElementException errors
//        TODO lower case SKUs?
        
        // multiples discount A B H K P Q V
        // BOGOF same F U
        // BOGOF different E N R
        // basic C D G I J L M O S T W X Y Z
        // NB some basic affected by offers

        // calculating BOGOF (same product)
        totalPrice += calculateBogofSameOffer(
            "F",
            skus.count { it == 'F' },
            3
        )
        totalPrice += calculateBogofSameOffer(
            "U",
            skus.count { it == 'U' },
            4
        )
        
        // calculating products with discounts for multiple of that item
        
        totalPrice += calculateMultiplesOffer(
            "A",
            skus.count { it == 'A' },
            Pair(3, 130),
            Pair(5, 200)
        )

        totalPrice += calculateMultiplesOffer(
            "B",
            skus.count { it == 'B' },
            Pair(2, 45),
            null
        )

        totalPrice += calculateMultiplesOffer(
            "H",
            skus.count { it == 'H' },
            Pair(5, 45),
            Pair(10, 80)
        )
        
        
        // calculating basic products (no special offers)
        for (sku in "CDGIJLMOSTWXYZ") {
            // TODO make sure this doesn't go below 0
            totalPrice += skus.count { it == sku } * prices.getValue(sku.toString())
        }
        return totalPrice
        
//
//        // calculating Es
//        val offerE = calculateOffer(
//            prices.getValue("E"),
//            skus.count { it == 'E' } * prices.getValue("E"),
//            2,
//            1
//        )
//        val adjustedBCount = skus.count { it == 'B' } - offerE.first
//        
//        // calculating Bs
//        val newB = calculateOffer(
//            prices.getValue("B"),
//            adjustedBCount * prices.getValue("B"),
//            2,
//            B_OFFER2
//        )
//        val totalB = newB.first + newB.second
//        
//        
//        
//        return totalA + 
//                (if (totalB <= 0) 0 else totalB) + 
//                (skus.count { it == 'C' } * prices.getValue("C")) + 
//                (skus.count { it == 'D' } * prices.getValue("D")) +
//                (skus.count { it == 'E' } * prices.getValue("E")) +
//                totalF
    }
    
    private fun calculateOffer(
        price: Int,
        total: Int,
        multiplier: Int,
        offer: Int
    ) : Pair<Int, Int> {
        val leftover = total % (price * multiplier)
        val reduced = ((total - leftover) / (price * multiplier)) * offer
        return Pair(reduced, leftover)
    }
    
    private fun calculateBogofSameOffer(
        sku: String,
        numItems: Int,
        requiredItems: Int,
    ) : Int {
        val skuPrice = prices.getValue(sku)
        val total = numItems * skuPrice
        val offerF = calculateOffer(
            skuPrice,
            total,
            requiredItems,
            1
        )
        return total - (offerF.first * skuPrice)
    }

    /** 
     * Offers shown as Pairs of the number of items needed to trigger it (first),
     *  and the reduced price (second).
     */
    private fun calculateMultiplesOffer(
        sku: String,
        numItems: Int,
        lowerOffer: Pair<Int, Int>,
        higherOffer: Pair<Int, Int>?
    ) : Int {
        val skuPrice = prices.getValue(sku)
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
}






