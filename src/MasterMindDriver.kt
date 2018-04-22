/**
 * Starting point of the Game.
 */
object MastermindDriver {

    @JvmStatic
    fun main(args: Array<String>) {

        val arrayOfPegs = PegFactory.getPegs(PegColor.values())
        //We are going to going to create the object of MasterMindGame inside the xml file used by Spring
        val mGame = MasterMindGame(true, ScannerImpl(4), MessageCentreImpl(StringBuilder()),12,
                ValidatorImpl(arrayOfPegs) ,ColorCodeGeneratorImpl(arrayOfPegs),4)
        mGame.runGames()

    }
}