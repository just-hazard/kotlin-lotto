package lotto.domain

import java.util.LinkedHashMap

class Statistic {
    private val matchResultMap: LinkedHashMap<WinnerAmountCategory, Int> = LinkedHashMap()

    companion object {
        private const val MATCH_DEFAULT_COUNT = 0
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

    }

    private fun matchResultInit() {
        WinnerAmountCategory.values()
            .forEach {
                matchResultMap[it] = MATCH_DEFAULT_COUNT
            }
    }
}
