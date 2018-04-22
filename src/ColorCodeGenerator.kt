/**
 * Responsible for generating the secret code to be cracked by
 * the user.
 */
interface ColorCodeGenerator {

    /**
     * Receives a number n and generates a code with size n.
     */
    fun colorCode(n: Int) : String
}