package lotto.domain

import domain.Value
import lotto.util.CommonException
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

class WinnerNumbersTest {

    private lateinit var winnerNumbers: WinnerNumbers

    @Test
    fun 당첨번호_생성() {
        winnerNumbers = WinnerNumbers("1,2,3,4,5,6",7)
        assertThat(winnerNumbers.winnerNumbers).containsExactly(LottoNumbers.of(1), LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(4),LottoNumbers.of(5),LottoNumbers.of(6))
    }

    @Test
    fun 보너스_번호_중복_체크() {
        Assertions.assertThatThrownBy {
            winnerNumbers = WinnerNumbers("1,2,3,4,5,6",1)
        }.isInstanceOf(RuntimeException::class.java)
            .hasMessage("당첨번호와 보너스 번호가 중복됩니다.")
    }
}
