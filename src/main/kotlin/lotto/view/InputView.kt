package lotto.view

import java.util.*

class InputView {

    companion object {

        private val sc: Scanner = Scanner(System.`in`)

        fun inputBuyMoney(): Int {
            println("구매 금액을 입력해주세요.")
            return sc.nextInt()
        }

        fun inputWinnerNumbers(): String {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return sc.next()
        }
    }
}
