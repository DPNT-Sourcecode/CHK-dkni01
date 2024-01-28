package solutions.SUM

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class SumSolutionTest {

    @Test
    fun sum() {
        Assertions.assertEquals(2, SumSolution.sum(1, 1))
        Assertions.assertEquals(0, SumSolution.sum(0, 0))

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            SumSolution.sum(200, 0)
        }
    }

    
}


