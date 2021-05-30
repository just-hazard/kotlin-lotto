package lotto.view

import lotto.domain.Lottos
import lotto.domain.Statistic

class ResultView {

    companion object {

        private var totalAmountMoney = 0

        fun statisticOutput(statistic: Statistic) {
            println("당첨 통계")
            println("---------")
            winningConfirm(statistic)
            rateOfReturn(statistic)

        }

        private fun rateOfReturn(statistic: Statistic) {
            print("총 수익률은 ${statistic.rateOfReturn(totalAmountMoney)}입니다.")
        }

        private fun winningConfirm(statistic: Statistic) {
            statistic.matchResultMap
                .forEach {
                    println("${it.key.message} (${it.key.winningAmount})원 - ${it.value}개")
                    totalAmountMoney += it.key.winningAmount * it.value
                }
        }

        fun lottosNumberPrint(lottos: Lottos, manualCount: Int) {
            println("수동으로 ${manualCount}장, 자동으로 ${lottos.lottoList.size - manualCount}개를 구매했습니다.")
            lottos.lottoList.forEach {
                println(it.toString())
            }
        }
    }
}
