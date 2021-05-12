package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottosTest {

    private lateinit var lottos: Lottos

    @BeforeEach
    fun setUp() {
        lottos = Lottos()
    }

    @Test
    fun 로또_자동_생성() {
        lottos.createAutoLotto(10)
        assertThat(lottos.lottoList.size).isEqualTo(10)
    }
}
