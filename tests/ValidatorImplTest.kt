import org.junit.Test
import org.junit.Assert.*

class ValidatorImplTest {

    private val v: ValidatorImpl = ValidatorImpl(arrayOf(PegImpl(PegColor.BLUE),PegImpl(PegColor.GREEN),PegImpl(PegColor.RED)))

    @Test
    fun validateTest(){
        assertEquals(true, v.validate("BGRB"))

        // No such color
        assertEquals(false, v.validate("BARB"))
        assertEquals(false, v.validate("BBRT"))
        assertEquals(false, v.validate("BRB1"))

        // Wrong size
        assertEquals(false, v.validate(""))
        assertEquals(false, v.validate("BRG"))
        assertEquals(false, v.validate("BRGBG"))

    }

    /*
     * All tests for Guess evaluation can be of equal size since comparing the guess
     * against the code happens only after the guess has been validated for compliance
     * with the game rules.
     */
    @Test
    fun evaluateTest() {

        assertEquals(Pair(false,Pair(1,0)), v.evaluateGuess("PRGP","GGGG"))
        assertEquals(Pair(false,Pair(2,0)), v.evaluateGuess("PRGP","PPPP"))
        assertEquals(Pair(true,Pair(4,0)), v.evaluateGuess("PRGP","PRGP"))

        assertEquals(Pair(false,Pair(0,0)), v.evaluateGuess("BBBP","RRRR"))
        assertEquals(Pair(false,Pair(3,0)), v.evaluateGuess("BBBP","BBBB"))
        assertEquals(Pair(false,Pair(2,1)), v.evaluateGuess("BBBP","BOBB"))
        assertEquals(Pair(false,Pair(2,2)), v.evaluateGuess("BBBP","PBBB"))
        assertEquals(Pair(false,Pair(2,2)), v.evaluateGuess("BBBP","BBPB"))
        assertEquals(Pair(true,Pair(4,0)), v.evaluateGuess("BBBP","BBBP"))

        assertEquals(Pair(false,Pair(1,0)), v.evaluateGuess("YRPO","RRRR"))
        assertEquals(Pair(false,Pair(0,0)), v.evaluateGuess("YRPO","BBBB"))
        assertEquals(Pair(false,Pair(1,0)), v.evaluateGuess("YRPO","OOOO"))
        assertEquals(Pair(false,Pair(1,0)), v.evaluateGuess("YRPO","PPPP"))
        assertEquals(Pair(false,Pair(0,0)), v.evaluateGuess("YRPO","GGGG"))
        assertEquals(Pair(false,Pair(1,0)), v.evaluateGuess("YRPO","YYYY"))
        assertEquals(Pair(false,Pair(1,3)), v.evaluateGuess("YRPO","ROPY"))
        assertEquals(Pair(false,Pair(0,2)), v.evaluateGuess("YRPO","ROBB"))
        assertEquals(Pair(false,Pair(0,2)), v.evaluateGuess("YRPO","ROGG"))
        assertEquals(Pair(false,Pair(0,4)), v.evaluateGuess("YRPO","ROYP"))
        assertEquals(Pair(false,Pair(1,0)), v.evaluateGuess("YRPO","RRRR"))
        assertEquals(Pair(false,Pair(0,0)), v.evaluateGuess("YRPO","BBBB"))
        assertEquals(Pair(true,Pair(4,0)), v.evaluateGuess("YRPO","YRPO"))

        assertEquals(Pair(false,Pair(1,1)), v.evaluateGuess("ADGBE","AEEET"))
        assertEquals(Pair(false,Pair(1,2)), v.evaluateGuess("ADGBE","AEEEB"))
        assertEquals(Pair(false,Pair(1,2)), v.evaluateGuess("ADGBE","AEEEB"))

        assertEquals(Pair(false,Pair(2,4)), v.evaluateGuess("RBPGED","DEPGBR"))
        assertEquals(Pair(false,Pair(1,5)), v.evaluateGuess("RBPGED","BPRGDE"))
        assertEquals(Pair(false,Pair(1,5)), v.evaluateGuess("RBPGED","BPRGDE"))
        assertEquals(Pair(false,Pair(1,2)), v.evaluateGuess("RBPGED","ABDAGA"))
    }

    @Test
    fun validatorImplTest(){
        val arrayOfPegs = PegFactory.getPegs(PegColor.values())
        val obj1 = ColorCodeGeneratorImpl(arrayOfPegs)

        val vld = ValidatorImpl(arrayOfPegs)
        var res=  vld.evaluateGuess("BYPG","BOOO")
        assertFalse(res.first)
        kotlin.test.assertTrue(res.second.first == 1)
        kotlin.test.assertTrue(res.second.second == 0)

        res = vld.evaluateGuess("BYPG","YPGB")

        assertFalse(res.first)
        kotlin.test.assertTrue(res.second.first == 0)
        kotlin.test.assertTrue(res.second.second == 4)

        res = vld.evaluateGuess("BYYY","YPGB")
        kotlin.test.assertTrue(res.second.first == 0)
        kotlin.test.assertTrue(res.second.second == 2)
    }
}