package lotto.view

import lotto.domain.Lotto
import lotto.domain.Money
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

        fun lottosNumberPrint(lottoList: MutableList<Lotto>) {
            lottoList.forEach {
                println(it.toString())
            }
        }
    }
}
