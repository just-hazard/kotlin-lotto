package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinnerAmountCategoryTest {
    @ParameterizedTest
    @CsvSource(value = ["0=0=꽝",
        "3=5000=3개 일치",
        "4=50000=4개 일치",
        "5=1500000=5개 일치",
        "6=2000000000=6개 일치"],
        delimiter = '=')
    fun 로또_결과_확인(matchNumber: Int,winningAmount: Int, message: String) {
        val winnerAmountCategory = WinnerAmountCategory.checkMatch(matchNumber)
        assertThat(winnerAmountCategory.matchNumber).isEqualTo(matchNumber)
        assertThat(winnerAmountCategory.winningAmount).isEqualTo(winningAmount)
        assertThat(winnerAmountCategory.message).isEqualTo(message)
    }
}
