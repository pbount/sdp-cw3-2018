import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class PegImplTest{

    lateinit var p1: Peg
    lateinit var p2: Peg
    lateinit var p3: Peg
    lateinit var p4: Peg
    lateinit var p5: Peg
    lateinit var listOfPegs: List<Peg>

    @Before
    fun beforeTest(){
        p1 = PegImpl(PegColor.GREEN)
        p2 = PegImpl(PegColor.RED)
        p3 = PegImpl(PegColor.YELLOW)
        p4 = PegImpl(PegColor.ORANGE)
        p5 = PegImpl(PegColor.BLUE)
        listOfPegs = listOf(p1,p2,p3,p4,p5)
    }


    @Test
    fun colorTestSuccess(){
        assertTrue(p1.color().isNotEmpty())
    }

    @Test
    fun colorLengthTestSuccess(){

        assertTrue(listOfPegs.all {
            it.color().length == 1
        } )
    }

    @Test
    fun colorTestFail() {
        assertFalse(p1.color().isEmpty())
    }

}