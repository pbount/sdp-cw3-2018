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
}