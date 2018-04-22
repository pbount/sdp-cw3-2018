/**
 * Generates all possible Pegs which can be used during the game.
 * The possibilities are determined by the PegColor enum class.
 */
object PegFactory {

    fun getPegs(pegColours: Array<PegColor>): Array<Peg> {

        return arrayOf(PegImpl(PegColor.BLUE))
    }
}


