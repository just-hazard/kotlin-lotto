package lotto.service

import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoGameTest {

    private lateinit var lottoGame: LottoGame

    @BeforeEach
    fun setUp() {
        lottoGame = LottoGame()
    }

    @Test
    fun 수동_구매_개수_초과_예외처리() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            lottoGame.validationBuyRange(10, 11)
        }.withMessage("구매하려는 개수가 보유한 코인보다 많습니다.")
    }
}
