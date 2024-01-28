package solutions.CHK

object CheckoutSolution {
    const val PRICE_A = 50
    const val PRICE_B = 30
    const val PRICE_C = 20
    const val PRICE_D = 15
    
    fun checkout(skus: String): Int {
        if (skus.any { !listOf('A', 'B', 'C', 'D').contains(it) }) {
            return -1
        }

        val numATotal = skus.count { it == 'A' } * PRICE_A
        val leftoverA = numATotal % 150
        val offerA = ((numATotal - leftoverA) / 150) * 130

        val numBTotal = skus.count { it == 'B' } * PRICE_B
        val leftoverB = numBTotal % 60
        val offerB = ((numBTotal - leftoverB) / 60) * 45
        
        return (offerA + leftoverA) + 
                (offerB + leftoverB) + 
                (skus.count { it == 'C' } * PRICE_C) + 
                (skus.count { it == 'D' } * PRICE_D)
    }
}
