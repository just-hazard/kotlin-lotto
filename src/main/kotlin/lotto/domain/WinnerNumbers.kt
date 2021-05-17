package lotto.domain

class WinnerNumbers(stringWinnerNumbers: String) {

    val winnerNumbers = mutableListOf<Number>()

    init {
        winnerNumbers.addAll(Splitter.splitStringNumbers(stringWinnerNumbers))
    }
}
