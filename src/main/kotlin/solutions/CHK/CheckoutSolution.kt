package solutions.CHK

object CheckoutSolution {
    const val PRICE_A = 50
    const val PRICE_B = 30
    const val PRICE_C = 20
    const val PRICE_D = 15
    
    const val A_OFFER3 = 130
    const val A_OFFER5 = 200
    const val B_OFFER2 = 45
    
    fun checkout(skus: String): Int {
        if (skus.any { !listOf('A', 'B', 'C', 'D').contains(it) }) {
            return -1
        }

        // calculating As
        val offerA5 = calculateAOffer(skus.count { it == 'A' } * PRICE_A, 5)
        val offerA3 = calculateAOffer(offerA5.second, 3)
        val totalA = offerA5.first + offerA3.first + offerA3.second
        
        // calculating Bs
        val numBTotal = skus.count { it == 'B' } * PRICE_B
        val leftoverB = numBTotal % (PRICE_B * 2)
        val offerB = ((numBTotal - leftoverB) / (PRICE_B * 2)) * B_OFFER2
        
        return (totalA) + 
                (offerB + leftoverB) + 
                (skus.count { it == 'C' } * PRICE_C) + 
                (skus.count { it == 'D' } * PRICE_D)
    }
    
    private fun calculateAOffer(total: Int, multiplier: Int) : Pair<Int, Int> {
        val offer: Int = if (multiplier == 3) {
            A_OFFER3
        } else {
            A_OFFER5
        }
        
        val leftoverA = total % (PRICE_A * multiplier)
        val offerA = ((total - leftoverA) / (PRICE_A * multiplier)) * offer
        return Pair(offerA, leftoverA)
    }
}





