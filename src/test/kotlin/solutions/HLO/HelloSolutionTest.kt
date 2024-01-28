package solutions.SUM

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import solutions.HLO.HelloSolution

class HelloSolutionTest {

    @Test
    fun hello() {
        Assertions.assertEquals("Hello, Ace!", HelloSolution.hello("Ace"))
        Assertions.assertEquals("Hello, John!", HelloSolution.hello("John"))
    }

    
}

