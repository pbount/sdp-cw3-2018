import org.junit.Assert
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
        Assert.assertTrue(factory.getPegs(arrayOfPegColor).isNotEmpty())
    }
}