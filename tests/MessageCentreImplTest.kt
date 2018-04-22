import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MessageCentreImplTest {

    lateinit var messageCentre: MessageCentre
    lateinit var res: String
    lateinit var randomText: String

    @Before
    fun beforeTest(){
        messageCentre = MessageCentreImpl(StringBuilder())
        randomText = "Random text"
    }

    @Test
    fun welcomeTestSuccess() {
        res = messageCentre.welcome()
        assertTrue(res.isNotEmpty())
        assertTrue(res.startsWith("""Welcome to Mastermind""".trimIndent()))
        assertTrue(res.endsWith("Generating secret code ...."))
    }

    @Test
    fun welcomeTestFailure(){
        res = messageCentre.welcome()
        assertFalse(res.isEmpty())
        assertFalse(randomText == res)
    }


    @Test
    fun successTestSuccess(){
        res = messageCentre.success()
        assertTrue(res.isNotEmpty())
        assertTrue(res == ("\nYou solved the puzzle! Good job.\n"))
    }

    @Test
    fun successTestFailure() {
        res = messageCentre.success()
        assertFalse(res.isEmpty())
        assertFalse(randomText == res)
    }

    @Test
    fun failTestSuccess() {
        res = messageCentre.fail()
        assertTrue(res.isNotEmpty())
        assertTrue(res == "You did not solve the puzzle. Too bad.")
    }

    @Test
    fun failTestFailure() {
        res = messageCentre.fail()
        res = messageCentre.success()
        assertFalse(res.isEmpty())
        assertFalse(randomText == res)
    }

    @Test
    fun instructionsTestSuccess(){
        res = messageCentre.instructions()
        assertTrue(res.isNotEmpty())
        assertTrue(res.startsWith("\nWhat is your next guess?\n"))
        assertTrue(res.endsWith("Enter guess: "))
    }


    @Test
    fun instructionsTestFailure(){
        res = messageCentre.instructions()
        assertFalse(res.isEmpty())
        assertFalse(res == randomText)
    }

    @Test
    fun guessesLeftTestSuccess() {

        for(i in -10..1000){
            assertTrue("\nYou have $i guesses left" == messageCentre.guessesLeft(i))
        }
    }

    @Test
    fun guessesLeftTestFailure(){
        res = messageCentre.guessesLeft(5)

        for(i in -1000 until 5){
            assertFalse("\nYou have $i guesses left" == res)
        }
    }

    @Test
    fun anotherGoTestSuccess(){
        res = messageCentre.anotherGo()
        assertTrue(res.isNotEmpty())
        assertTrue(res == "Enter Y for another game or anything else to quit: ")
    }

    @Test
    fun anotherGoTestFail(){
        res = messageCentre.anotherGo()
        assertFalse(res.isEmpty())
        assertFalse(res == randomText)
    }

    @Test
    fun resultsNotAnEmptyStringTestSuccess(){
        res = messageCentre.results("BOPY", Pair(3,1))
        assertTrue(res.isNotEmpty())
    }

    @Test
    fun resultsThreeBlackOneWhiteTestSuccess(){
        val inp = "BOPY"
        res = messageCentre.results(inp, Pair(3,1))
        assertTrue("BOPY Result: Black Black Black White" == res.trim() )

    }

    @Test
    fun resultsOneBlackThreeWhiteTestSuccess(){
        val inp = "BOPY"
        res = messageCentre.results(inp, Pair(1,3))
        assertTrue("BOPY Result: Black White White White" == res.trim())
    }

    @Test
    fun resultsNoPegsTestSuccess(){
        val inp = "BOPY"
        res = messageCentre.results(inp, Pair(0,0))
        assertTrue("$inp Result: No Pegs"== res.trim())
    }

    @Test
    fun resultsMoreThanInputTestSuccess(){
        var inp = "BOPY"
        res = messageCentre.results(inp, Pair(1,0))
        inp = "BOBB"
        res = messageCentre.results(inp, Pair(1,1))
        val stb = StringBuilder()
        stb.append("\nBOPY Result: Black ")
        stb.append("\nBOBB Result: Black White")
        assertTrue(res.trim() == stb.toString().trim())

    }

    @Test
    fun resultsTestFailure() {
        var inp = "BOPY"
        res = messageCentre.results(inp, Pair(0,0))
        assertFalse(res.isEmpty())
    }

    @Test
    fun resultsRandomTextTestFailure() {
        var inp = "BOPY"
        res = messageCentre.results(inp, Pair(0,0))
        assertFalse(res == randomText)
    }

}