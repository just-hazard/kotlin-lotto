package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    private lateinit var lottoNumbers: LottoNumbers

    @BeforeEach
    fun setUp() {
        lottoNumbers = LottoNumbers()
    }

    @Test
    fun 정적인_로또번호들_생성() {
        assertThat(lottoNumbers.numberSize()).isEqualTo(45)
    }
}
