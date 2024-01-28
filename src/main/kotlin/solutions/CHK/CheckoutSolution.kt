package solutions.CHK

object CheckoutSolution {
    const val PRICE_A = 50
    const val PRICE_B = 30
    const val PRICE_C = 20
    const val PRICE_D = 15
    const val PRICE_E = 40
    
    const val A_OFFER3 = 130
    const val A_OFFER5 = 200
    const val B_OFFER2 = 45
    
    fun checkout(skus: String): Int {
        if (skus.any { !listOf('A', 'B', 'C', 'D', 'E').contains(it) }) {
            return -1
        }

        // calculating As
        val offerA5 = calculateBasicOffer(
            PRICE_A, 
            skus.count { it == 'A' } * PRICE_A, 
            5,
            A_OFFER5
        )
        val offerA3 = calculateBasicOffer(
            PRICE_A,
            offerA5.second,
            3,
            A_OFFER3
        )
        val totalA = offerA5.first + offerA3.first + offerA3.second

        // calculating Es
        val offerE = calculateBasicOffer(
            PRICE_E,
            skus.count { it == 'E' } * PRICE_E,
            2,
            1
        )
        val adjustedBCount = skus.count { it == 'B' } - offerE.first
        
        // calculating Bs
        val newB = calculateBasicOffer(
            PRICE_B,
            adjustedBCount * PRICE_B,
            2,
            B_OFFER2
        )
        val totalB = newB.first + newB.second
        
        return (totalA) + 
                (totalB) + 
                (skus.count { it == 'C' } * PRICE_C) + 
                (skus.count { it == 'D' } * PRICE_D) +
                (skus.count { it == 'E' } * PRICE_E)
    }
    
    private fun calculateBasicOffer(price: Int,
                                    total: Int,
                                    multiplier: Int,
                                    offer: Int
    ) : Pair<Int, Int> {
        val leftover = total % (price * multiplier)
        val reduced = ((total - leftover) / (price * multiplier)) * offer
        return Pair(reduced, leftover)
    }
}
