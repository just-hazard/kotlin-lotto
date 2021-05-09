package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun 금액이_1000원이상인지_체크() {
        assertThatIllegalArgumentException().isThrownBy {
            Money(500)
        }.withMessage("로또 한장당 구매금액은 1000원 입니다.")
    }

    @Test
    fun 로또_생성_개수확인() {
        val money = Money(10000)
        assertThat(money.coin.coin).isEqualTo(10)
    }

    @Test
    fun 거스름돈_반환_확인() {
        val money = Money(10500)
        assertThat(money.remainMoney).isEqualTo(500)
    }
}
