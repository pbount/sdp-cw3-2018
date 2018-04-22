import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PegFactoryTest {


    lateinit var factory :PegFactory
    lateinit var arrayOfPegColor: Array<PegColor>

    @Before
    fun beforeTest(){
        factory = PegFactory
        arrayOfPegColor = PegColor.values()
    }

    @Test
    fun getPegsNotEmptyTestSuccess(){
        assertTrue(factory.getPegs(arrayOfPegColor).isNotEmpty())
    }

    @Test
    fun getPegsSameSizeTestSuccess() {
        assertTrue(factory.getPegs(arrayOfPegColor).size == arrayOfPegColor.size)
    }

    @Test
    fun getPegsObjectTypeTestSuccess() {
        assertTrue(factory.getPegs(arrayOfPegColor).all {
            it is Peg
        })
    }

    @Test
    fun getPegsTestFail(){
        assertFalse(factory.getPegs(arrayOfPegColor).isEmpty())
    }


    @Test
    fun getPegsSizeTestFail() {
        val arr = arrayOf(PegColor.YELLOW,PegColor.BLUE, PegColor.GREEN)
        assertFalse(factory.getPegs(arr).size == arrayOfPegColor.size)
    }

    @Test
    fun getPegsObjectTypeFail() {
        assertFalse(factory.getPegs(arrayOfPegColor).all {
            it !is Peg
        })
    }
}