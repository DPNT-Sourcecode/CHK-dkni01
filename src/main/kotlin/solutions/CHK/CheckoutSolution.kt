package solutions.CHK

object CheckoutSolution {
    fun checkout(skus: String): Int {
        val PRICE_A = 50
        val PRICE_B = 30
        val PRICE_C = 20
        val PRICE_D = 15
        
        val numA = skus.count { it == 'A'}
        val numB = skus.count { it == 'B'}
        val numC = skus.count { it == 'C'}
        val numD = skus.count { it == 'D'}
        
        val sums = (numA * PRICE_A) + (numB * PRICE_B) + (numC * PRICE_C) + (numD * PRICE_D)
        return sums
        
//        return -1
    }
}

