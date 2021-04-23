package domain

class StringCalculator(inputString: String) {

    private var splitStringDelimiter = SplitStringDelimiter()
    private var values: Values = Values(splitStringDelimiter.splitString(inputString))

    fun sumStringNumber(): Int {
        return values.sum()
    }

}
