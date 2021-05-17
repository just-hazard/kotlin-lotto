package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WinnerNumbersTest {

    private lateinit var winnerNumbers: WinnerNumbers

    @BeforeEach
    fun setUp() {
        winnerNumbers = WinnerNumbers("1,2,3,4,5,6")
    }

    @Test
    fun 당첨번호_생성() {
        assertThat(winnerNumbers.winnerNumbers).containsExactly(LottoNumbers.of(1), LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(4),LottoNumbers.of(5),LottoNumbers.of(6))
    }
}
