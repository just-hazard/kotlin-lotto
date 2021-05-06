package lotto.domain

import java.util.*

enum class WinnerAmountCategory(var matchNumber: Int,var winningAmount: Int,var message: String) {
    ZERO(0, 0, "꽝"),
    FIFTH(3, 5000, "3개 일치"),
    FORTH(4, 50000, "4개 일 치"),
    THIRD(5, 1500000, "5개 일치"),
//    SECOND(5, 30000000, "5개 일치 보너스 볼 일치"),
    FIRST(6, 2000000000, "6개 일치");

    companion object {
        fun matchCheck(matchNumber: Int): WinnerAmountCategory {
            return Arrays.stream(values()).filter {
                it.matchNumber == matchNumber
            }.findAny().orElse(ZERO)
        }
    }
}
