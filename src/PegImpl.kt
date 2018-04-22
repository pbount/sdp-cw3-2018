/**
 * A Peg as used during the game.
 * Each peg holds it's color designated to it at creation time.
 */
open class PegImpl(private val pegColour: PegColor): Peg {

    /**
     * Returns the first character of Color name as String.
     * i.e: BLACK -> B, RED -> R etc.
     */
    override fun color(): String {
        return pegColour.name.substring(0,1)
    }
}
