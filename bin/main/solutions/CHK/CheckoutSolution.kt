package solutions.CHK

object CheckoutSolution {
    val prices = hashMapOf<String, Int>(
        | A    | 50    | 3A for 130, 5A for 200 |
    | B    | 30    | 2B for 45              |
    | C    | 20    |                        |
    | D    | 15    |                        |
    | E    | 40    | 2E get one B free      |
    | F    | 10    | 2F get one F free      |
    | G    | 20    |                        |
    | H    | 10    | 5H for 45, 10H for 80  |
    | I    | 35    |                        |
    | J    | 60    |                        |
    | K    | 80    | 2K for 150             |
    | L    | 90    |                        |
    | M    | 15    |                        |
    | N    | 40    | 3N get one M free      |
    | O    | 10    |                        |
    | P    | 50    | 5P for 200             |
    | Q    | 30    | 3Q for 80              |
    | R    | 50    | 3R get one Q free      |
    | S    | 30    |                        |
    | T    | 20    |                        |
    | U    | 40    | 3U get one U free      |
    | V    | 50    | 2V for 90, 3V for 130  |
    | W    | 20    |                        |
    | X    | 90    |                        |
    | Z    | 50    |                        |
    | Y    | 10    |                        |
    )
    
    const val PRICE_A = 50
    const val PRICE_B = 30
    const val PRICE_C = 20
    const val PRICE_D = 15
    const val PRICE_E = 40
    const val PRICE_F = 10
    
    const val A_OFFER3 = 130
    const val A_OFFER5 = 200
    const val B_OFFER2 = 45
    
    fun checkout(skus: String): Int {
        if (skus.any { !listOf('A', 'B', 'C', 'D', 'E', 'F').contains(it) }) {
            return -1
        }

        // calculating As
        val offerA5 = calculateOffer(
            PRICE_A, 
            skus.count { it == 'A' } * PRICE_A, 
            5,
            A_OFFER5
        )
        val offerA3 = calculateOffer(
            PRICE_A,
            offerA5.second,
            3,
            A_OFFER3
        )
        val totalA = offerA5.first + offerA3.first + offerA3.second

        // calculating Es
        val offerE = calculateOffer(
            PRICE_E,
            skus.count { it == 'E' } * PRICE_E,
            2,
            1
        )
        val adjustedBCount = skus.count { it == 'B' } - offerE.first
        
        // calculating Bs
        val newB = calculateOffer(
            PRICE_B,
            adjustedBCount * PRICE_B,
            2,
            B_OFFER2
        )
        val totalB = newB.first + newB.second
        
        // calculating Fs
        val offerF = calculateOffer(
            PRICE_F,
            skus.count { it == 'F' } * PRICE_F,
            3,
            1
        )
        val totalF = (skus.count { it == 'F' } * PRICE_F) - (offerF.first * PRICE_F)
        
        return totalA + 
                (if (totalB <= 0) 0 else totalB) + 
                (skus.count { it == 'C' } * PRICE_C) + 
                (skus.count { it == 'D' } * PRICE_D) +
                (skus.count { it == 'E' } * PRICE_E) +
                totalF
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
}
