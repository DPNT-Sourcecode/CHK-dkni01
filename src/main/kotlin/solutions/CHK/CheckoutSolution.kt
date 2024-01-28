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
        val leftover = numATotal % 150
        val offerA = (numATotal % 150) * 130
        val newtotalA = offerA + leftover
        
        
//        println("❗️ $checkAOffer")
//        println("❗️ ${4 % 3}")
        
//        if (numA > 3) {
//            numA = (numA - 150) + 130
//        }
        
        val sums = (newtotalA) + (numB * PRICE_B) + (numC * PRICE_C) + (numD * PRICE_D)
        return sums
        
//        return -1
    }
}




