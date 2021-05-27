package lotto.view

import java.util.*

class InputView {

    companion object {

        private val sc: Scanner = Scanner(System.`in`)

        fun inputBuyMoney(): Int {
            println("구매 금액을 입력해주세요.")
            return inputIntScanner()
        }

        fun inputWinnerNumbers(): String {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return inputStringScanner()
        }
        fun inputManualBuyCount(): Int {
            println("수동으로 구매할 로또 수를 입력해 주세요.")
            return inputIntScanner()
        }

        fun inputManualNumbers(): String {
            println("수동으로 구매할 번호를 입력해 주세요.")
            return inputStringScanner()
        }

        fun inputBonusBall(): Int {
            println("보너스 볼을 입력해 주세요.")
            return inputIntScanner()
        }

        private fun inputStringScanner(): String {
            return sc.next()
        }

        private fun inputIntScanner() = sc.nextInt()
    }
}
