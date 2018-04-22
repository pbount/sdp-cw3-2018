/**
 * Validator is used to validate the input for compliance with game rules
 * as well as for correctness against the secret code.
 */
interface Validator {

    /**
     * Verifies that the input follows game rules.
     * Returns true if input is valid and false otherwise.
     */
    fun validate(input:String): Boolean

    /**
     * Compares the input against the secret code and returns a Pair of a
     * Boolean indicating whether the input and code are the same and a Pair of
     * the number of Black and White pegs (in that order).
     */
    fun evaluateGuess(secretKey: String, guess:String): Pair<Boolean, Pair<Int, Int>>
}