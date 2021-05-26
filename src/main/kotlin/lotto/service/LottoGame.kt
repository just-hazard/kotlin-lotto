package lotto.service

import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.Statistic
import lotto.domain.WinnerNumbers
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame {

    private lateinit var statistic: Statistic

    // InputView 도메인을 통해 금액을 입력 받아 코인으로 전환 clear
    // 코인을 통해 로또 구매 clear
    // 당첨 번호 구하기 clear
    // 통계

    fun start() {
        ResultView.statisticOutput(statistic())
    }

    private fun statistic() : Statistic {
        statistic = Statistic()
        statistic.confirmOfLotto(buyLotto(changeCoin(InputView.inputBuyMoney())),
            createWinnerNumbers(InputView.inputWinnerNumbers()))
        return statistic
    }

    private fun changeCoin(inputBuyMoney: Int): Int {
        val money = Money(inputBuyMoney)
        return money.coin.coin
    }

    private fun createWinnerNumbers(inputWinnerNumbers: String): WinnerNumbers {
        // 보너스볼 리팩토링
        return WinnerNumbers(inputWinnerNumbers,1)
    }

    private fun buyLotto(coin : Int) : Lottos {
        val lottos = Lottos()
        lottos.createAutoLotto(coin)
        ResultView.lottosNumberPrint(lottos.lottoList)
        return lottos
    }
}
