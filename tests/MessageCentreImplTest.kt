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
}