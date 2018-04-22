interface MessageCentre {

    val stringBuilder: StringBuilder
    fun welcome(): String
    fun success(): String
    fun fail(): String
    fun instructions(): String
    fun guessesLeft(n: Int): String
    fun anotherGo(): String
    fun results(inp: String,result: Pair<Int,Int>): String
    fun secretCode(secretCode: String): String
}