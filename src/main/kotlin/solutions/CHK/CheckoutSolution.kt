package solutions.CHK

object CheckoutSolution {
    fun checkout(skus: String): Int {
        if (skus.any { !listOf('A', 'B', 'C', 'D').contains(it) }) {
            return -1
        }
        
        val PRICE_A = 50
        val PRICE_B = 30
        val PRICE_C = 20
        val PRICE_D = 15
        
        var numA = skus.count { it == 'A'}
        val numB = skus.count { it == 'B'}
        val numC = skus.count { it == 'C'}
        val numD = skus.count { it == 'D'}
        
        val numATotal = numA * PRICE_A
        val leftoverA = numATotal % 150
        val offerA = ((numATotal-leftoverA) / 150) * 130
//            val newtotalA = offerA + leftoverA
//            println("❗️ $leftoverA, $offerA, $newtotalA")

        val numBTotal = numB * PRICE_B
        val leftoverB = numBTotal % 60
        val offerB = ((numBTotal-leftoverB) / 60) * 45
        
        
        val sums = (offerA + leftoverA) + (offerB + leftoverB) + (numC * PRICE_C) + (numD * PRICE_D)
        return sums
        
//        return -1
    }
}







