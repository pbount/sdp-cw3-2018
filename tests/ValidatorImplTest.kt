import org.junit.Test
import org.junit.Assert.*

class ValidatorImplTest {

    private val v: ValidatorImpl = ValidatorImpl(arrayOf(PegImpl(PegColor.BLUE), PegImpl(PegColor.GREEN), PegImpl(PegColor.RED)))

    @Test
    fun validateTest() {
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
}