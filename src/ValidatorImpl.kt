class ValidatorImpl(validInput: Array<Peg>): Validator {

    private val validColors: String = validInput.fold("",{x,y -> x + y.color()})

    /**
     * Verifies that the input follows game rules.
     * Returns true if input is valid and false otherwise.
     */
    override fun validate(input: String): Boolean {

        if(input.length != 4) {
            return false
        }

        input.forEach { if(!validColors.contains(it.toString())) return false  }
        return true
    }

    /**
     * Compares the input against the secret code and returns a Pair of a
     * Boolean indicating whether the input and code are the same and a Pair of
     * the number of Black and White pegs (in that order).
     */
    override fun evaluateGuess(secretKey: String, guess: String) : Pair<Boolean, Pair<Int, Int>> {
        var black = 0
        var white = 0
        var stringToCheck = guess
        val matchArray = BooleanArray(secretKey.length)


        for (i in 0 until secretKey.length) {

            if (guess[i] == secretKey[i]) {
                black++
                matchArray[i] = true
            } else {

                for (j in 0 until stringToCheck.length) {

                    if (stringToCheck[j] == secretKey[i] && !matchArray[i] && j!=i) {

                        matchArray[i] = true
                        white++
                        stringToCheck = stringToCheck.replace(stringToCheck[j].toString(),"")

                        break
                    }
                }
            }
        }
        return Pair(black == secretKey.length, Pair(black, white))
    }
}