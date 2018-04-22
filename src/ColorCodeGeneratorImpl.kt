import java.util.*

/**
 * Responsible for generating the secret code to be cracked by
 * the user.
 *
 * arrayOfPegs represents all valid pegs which can be used to generate
 * the secret code.
 */
class ColorCodeGeneratorImpl(private val arrayOfPegs: Array<Peg>): ColorCodeGenerator {

    /**
     * Receives a number n and generates a code with size n.
     */
    override fun colorCode (n: Int) : String {
        TODO()
    }
}