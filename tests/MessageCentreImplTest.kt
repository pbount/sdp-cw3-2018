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
}