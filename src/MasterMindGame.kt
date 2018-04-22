/**
 * MasterMindGame is a Game type object responsible for coordinating different parts of
 * the game. This is the main calling point for the games functionality situated
 * in other classes.
 */
class MasterMindGame(private val showCode: Boolean, private val scanner: Scanner, private val msgCentre: MessageCentre,
                     private val numberOfTries: Int,private val validator: Validator
                     , private val colorCodeGenerator: ColorCodeGenerator, private val complexity: Int):
 GameAbstractImpl(showCode){

    /* The secret code to be cracked by the user */
    private var code = colorCodeGenerator.colorCode(complexity)


    override fun runGames() {

        /* Welcome message */
        println(msgCentre.welcome())

        /* Difficulty configuration */
        if(showCode) {
            println(msgCentre.secretCode(code))
        }

        /* Display game instructions */
        println(msgCentre.guessesLeft(numberOfTries))
        print(msgCentre.instructions())


        /* First user input */
        val firstInp = scanner.scan()

        /*Loop until user is left with no more tries or
         successfully guess the secret code*/
        fun loop(numberOfTriesLeft: Int, input: String) {


            /* User input should be following game rules */
            if(!validator.validate(input)) {
                print(msgCentre.instructions())
                loop(numberOfTriesLeft - 1, scanner.scan())
            }

            /* Display the code on each loop */
            if(showCode) {
                println(msgCentre.secretCode(code))
            }


            /* Compare user input to code and provide feedback */
            val result = validator.evaluateGuess(code, input)
            when(result.first) {
                true -> {
                   //success
                    restartGame()
                }
                else -> {
                    when(numberOfTriesLeft) {
                        0 -> {
                            //fail
                            restartGame()
                        }
                        else -> {
                            //fail show results
                            //try again
                            loop(numberOfTriesLeft-1,scanner.scan())
                        }
                    }
                }
            }

        }
        
        loop(numberOfTries-1, firstInp)

    }



    /**
     * Executes the game.
     */
    override fun restartGame() {
        println(msgCentre.anotherGo())
        val reply = scanner.scan()
        if(reply == "Y") {
            code = colorCodeGenerator.colorCode(complexity)
            runGames()
        }
    }

}