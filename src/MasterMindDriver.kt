import org.springframework.beans.factory.BeanFactory
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Starting point of the Game.
 */
object MastermindDriver {

    private val ROOT = System.getProperty("user.dir")
    private val beanFactory: BeanFactory
        @Throws(Exception::class)
        get() = ClassPathXmlApplicationContext("file:$ROOT/beans.xml")
    @JvmStatic
    fun main(args: Array<String>) {

       /** val arrayOfPegs = PegFactory.getPegs(PegColor.values())
        //We are going to going to create the object of MasterMindGame inside the xml file used by Spring
        val mGame = MasterMindGame(true, ScannerImpl(4), MessageCentreImpl(StringBuilder()),12,
                ValidatorImpl(arrayOfPegs) ,ColorCodeGeneratorImpl(arrayOfPegs),4)
        mGame.runGames() **/

       val factory = beanFactory
        val masterMindGame = factory.getBean("masterMindGame") as MasterMindGame
        masterMindGame.runGames()

    }
}