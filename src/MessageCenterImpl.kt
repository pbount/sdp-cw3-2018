class MessageCentreImpl(override val stringBuilder: StringBuilder) : MessageCentre {
    override fun welcome(): String {
        return """
            Welcome to Mastermind.

            This is a text version of the classic board game Mastermind.
            The computer will think of a secret code.
            The code consists of 4 colored pegs.
            The pegs may be one of six colors: blue, green , orange, purple, red, or yellow.
            q1_2.A color may appear more than once in the code.

            You try to guess what colored pegs are in the code and what order they are in
            After making a guess the result will be displayed.
            q1_2.A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.
            For each peg in the guess that is the correct color, but is out of position, you get a white peg.

            Only the first letter of the color is displayed. q1_2.B for Blue, R for Red, and so forth.
            When entering guesses you only need to enter the first character of the color as a capital letter.

            You have 12 to guess the answer or you lose the game.

            Generating secret code ....
      """.trimIndent()

    }

    override fun success(): String = "\nYou solved the puzzle! Good job.\n"

    override fun fail(): String = "You did not solve the puzzle. Too bad."

    override fun instructions(): String = "\nWhat is your next guess?\n" +
            "Type in the characters for your guess and press enter.\n" +
            "Enter guess: "

    override fun guessesLeft(n: Int): String = "\nYou have $n guesses left"

    override fun anotherGo(): String = "Enter Y for another game or anything else to quit: "

    override fun results(inp: String, result: Pair<Int, Int>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun secretCode(secretCode: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}