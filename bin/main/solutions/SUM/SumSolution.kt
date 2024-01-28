package solutions.SUM

import java.lang.IllegalArgumentException

object SumSolution {
    fun sum(x: Int, y: Int): Int {
        if (x > 100 || y > 100 || x < 0 || y < 0) {
            throw IllegalArgumentException("Inputs must be within 0-100 inclusive.")
        }
        
        return x + y
    }
}

