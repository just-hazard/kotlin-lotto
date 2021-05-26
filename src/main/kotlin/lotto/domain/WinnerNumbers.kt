package lotto.domain

import lotto.util.CommonException
import lotto.util.CommonValidation

class WinnerNumbers(stringWinnerNumbers: String, inputBonusBall: Int) {
    val winnerNumbers = mutableListOf<Number>()
    private val bonusBall: Number

    init {
        winnerNumbers.addAll(Splitter.splitStringNumbers(stringWinnerNumbers))
        bonusBall = LottoNumbers.of(inputBonusBall)
        bonusBallOverlapCheck()
        CommonValidation.validationLengthCheck(winnerNumbers)
        CommonValidation.validationOverlap(winnerNumbers)
    }

    private fun bonusBallOverlapCheck() {
        if(isSameNumber(bonusBall)) {
            CommonException.overlapException("당첨번호와 보너스 번호가 중복됩니다.")
        }
    }

    fun isSameNumber(number: Number) : Boolean {
        return winnerNumbers.stream().anyMatch {
            number.isSameNumber(number, it)
        }
    }
}
