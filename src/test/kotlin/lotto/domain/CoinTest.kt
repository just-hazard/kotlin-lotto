package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CoinTest {
    @Test
    fun 코인_충전() {
        val coin = Coin()
        coin.coinCharge()
        coin.coinCharge()
        assertThat(coin.coin).isEqualTo(2)
    }
}
