package lotto.domain

import lotto.util.CommonValidation

class WinnerNumbers(stringWinnerNumbers: String) {
    val winnerNumbers = mutableListOf<Number>()

    init {
        winnerNumbers.addAll(Splitter.splitStringNumbers(stringWinnerNumbers))
        CommonValidation.validationLengthCheck(winnerNumbers)
        CommonValidation.validationOverlap(winnerNumbers)
    }

    fun isSameNumber(number: Number) : Boolean {
        return winnerNumbers.stream().anyMatch {
            number.isSameNumber(number, it)
        }
    }
}
