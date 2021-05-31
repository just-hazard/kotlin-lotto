package lotto.service

import lotto.domain.*
import lotto.view.InputView
import lotto.view.ResultView
import java.util.stream.Stream

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
            createWinnerNumbers(InputView.inputWinnerNumbers(), InputView.inputBonusBall()))
        return statistic
    }

    private fun changeCoin(inputBuyMoney: Int): Int {
        val money = Money(inputBuyMoney)
        return money.getCoin()
    }

    private fun createWinnerNumbers(inputWinnerNumbers: String, inputBonusBall: Int): WinnerNumbers {
        return WinnerNumbers(inputWinnerNumbers,inputBonusBall)
    }

    private fun buyLotto(coin : Int) : Lottos {
//        수동으로 구매할 로또 수 입력 (Input Number)
//        수동으로 입력한 개수 만큼 수동으로 로또 구매
//        수동 몇장 자동 몇장 구매했습니다 매세징 후 통합
        val lottos = Lottos()
        lottos.lottoList.addAll(createManualLottos(validationBuyRange(coin, InputView.inputManualBuyCount())))
        val manualCount = lottos.getLottoSize()
        lottos.createAutoLotto(coin - manualCount)
        ResultView.lottosNumberPrint(lottos, manualCount)
        return lottos
    }

    internal fun validationBuyRange(coin: Int, inputManualBuyCount: Int): Int {
        if(coin < inputManualBuyCount)
        {
            throw IllegalArgumentException("구매하려는 개수가 보유한 코인보다 많습니다.")
        }
        return inputManualBuyCount
    }

    private fun createManualLottos(inputManualBuyCount: Int): List<Lotto> {
        val manualLottos: MutableList<Lotto> = mutableListOf()
        InputView.inputManualMessage()
        repeat(inputManualBuyCount) {
            manualLottos.add(Lotto(Splitter.splitStringNumbers(InputView.inputManualNumbers())))
        }

        return manualLottos
    }
}
