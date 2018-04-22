
class ScannerImpl(inputSize: Int): Scanner {

    /**
     * Reads an input from the console and returns it as String.
     */
    override fun scan(): String {
        val res = readLine()
        return res!!
    }
}