package lotto.domain

class WinnerNumbers(stringWinnerNumbers: String) {
    val winnerNumbers = mutableListOf<Number>()

    init {
        winnerNumbers.addAll(Splitter.splitStringNumbers(stringWinnerNumbers))
    }

    fun isSameNumber(number: Number) : Boolean {
        return winnerNumbers.stream().anyMatch {
            number.isSameNumber(number, it)
        }
    }
}
