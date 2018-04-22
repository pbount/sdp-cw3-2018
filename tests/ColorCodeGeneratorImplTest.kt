import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ColorCodeGeneratorImplTest {

    private lateinit var obj1: ColorCodeGeneratorImpl
    private lateinit var arrayOfPegs: Array<Peg>
    private lateinit var listOfAcceptableValues : List<String>

    @Before
    fun beforeTest(){
        arrayOfPegs = PegFactory.getPegs(PegColor.values())
        listOfAcceptableValues = arrayOfPegs.map { it.color() }

        obj1 = ColorCodeGeneratorImpl(arrayOfPegs)

    }

    /**
     * Tests that the generated values are all acceptable.
     */
    @Test
    fun colorCodeTest() {

        for(i in 0..100000){
            val res = obj1.colorCode(4)
            assertTrue(res.length == 4)
            res.forEach { assertTrue(listOfAcceptableValues.contains(it.toString())) }
        }

    }
}