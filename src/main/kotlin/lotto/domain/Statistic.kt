package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class Statistic {
    val matchResultMap: LinkedHashMap<WinnerAmountCategory, Int> = LinkedHashMap()

    companion object {
        private const val MATCH_DEFAULT_COUNT = 0
        private const val COUNT = 1
        private const val TWO_DECIMAL = 2
    }

    fun confirmOfLotto(lottos: Lottos, winnerNumbers: WinnerNumbers) {
        matchResultInit()

        lottos.lottoList.map {
            it.getNumbers()
        }.forEach {
            matchWinnerAmount(winnerNumbers, it)
        }
    }

    private fun matchWinnerAmount(winnerNumbers: WinnerNumbers, numbers: List<Number>) {
        matchCount(WinnerAmountCategory.checkMatch(checkMatchNumbers(winnerNumbers, numbers), winnerNumbers.checkMatchBonusBall(numbers)))
    }

    private fun matchCount(matchWinnerAmountCategory: WinnerAmountCategory) {
        matchResultMap[matchWinnerAmountCategory] = matchResultMap[matchWinnerAmountCategory]!! + COUNT
    }

    private fun checkMatchNumbers(winnerNumbers: WinnerNumbers, numbers: List<Number>): Int {
        return numbers.filter {
            winnerNumbers.isSameNumber(it)
        }.count()
    }

    private fun matchResultInit() {
        WinnerAmountCategory.values()
            .forEach {
                matchResultMap[it] = MATCH_DEFAULT_COUNT
            }
    }

    fun rateOfReturn(totalAmountMoney: Int): Double {
        return BigDecimal.valueOf(totalAmountMoney.toDouble() / totalBuyCount().toDouble())
            .setScale(TWO_DECIMAL, RoundingMode.DOWN).toDouble()
    }

    private fun totalBuyCount(): Int {
        var count = 0
        matchResultMap.values
            .forEach {
                count += it
            }
        return count
    }

}
