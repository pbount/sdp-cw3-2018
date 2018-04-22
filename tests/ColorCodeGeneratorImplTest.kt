import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.*

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

    @Test
    fun testBoundsOFRandom() {
        var res0 = 0
        var res1 = 0
        var res2 = 0
        for(i in 0..10000) {
            val res = Random().nextInt(3)

            if (res == 0) {
                res0 += 1
            }
            if (res == 1) {
                res1 += 1
            }
            if (res == 2) {
                res2 += 1
            }
            assertTrue(res in 0..3)
        }
    }
}