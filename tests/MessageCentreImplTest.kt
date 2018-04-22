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

}