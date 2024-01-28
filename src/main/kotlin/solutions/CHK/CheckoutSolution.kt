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

        val numATotal = skus.count { it == 'A' } * PRICE_A
        
        if (numATotal > PRICE_A * 5) {
            val leftoverA = numATotal % (PRICE_A * 5)
            val offerA = ((numATotal - leftoverA) / (PRICE_A * 5)) * A_OFFER5
            println("❗️ 5 offer ${offerA + leftoverA}")
        }
        
        val leftoverA = numATotal % (PRICE_A * 3)
        val offerA = ((numATotal - leftoverA) / (PRICE_A * 3)) * A_OFFER3

        val numBTotal = skus.count { it == 'B' } * PRICE_B
        val leftoverB = numBTotal % (PRICE_B * 2)
        val offerB = ((numBTotal - leftoverB) / (PRICE_B * 2)) * B_OFFER2
        
        return (offerA + leftoverA) + 
                (offerB + leftoverB) + 
                (skus.count { it == 'C' } * PRICE_C) + 
                (skus.count { it == 'D' } * PRICE_D)
    }
}

