package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StatisticTest {

    private lateinit var statistic: Statistic
    private lateinit var lottos: Lottos
    private lateinit var winnerNumbers: WinnerNumbers

    @BeforeEach
    fun setUp() {
        statistic = Statistic()
        lottos = Lottos()
        winnerNumbers = WinnerNumbers("1,2,3,4,5,6",45)
    }

    @Test
    fun 통계_당첨_확인() {
        // given
        lottos.lottoList.addAll(
            listOf(Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(4),LottoNumbers.of(5),LottoNumbers.of(6))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(4),LottoNumbers.of(5),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(4),LottoNumbers.of(8),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(9),LottoNumbers.of(8),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(10),LottoNumbers.of(9),LottoNumbers.of(8),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(11),LottoNumbers.of(12),LottoNumbers.of(13),LottoNumbers.of(14))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(4),LottoNumbers.of(5),LottoNumbers.of(45)))
            )
        )

        // when
        statistic.confirmOfLotto(lottos, winnerNumbers)

        // then
        assertThat(statistic.matchResultMap[WinnerAmountCategory.FIRST]).isEqualTo(1)
        assertThat(statistic.matchResultMap[WinnerAmountCategory.SECOND]).isEqualTo(1)
        assertThat(statistic.matchResultMap[WinnerAmountCategory.THIRD]).isEqualTo(1)
        assertThat(statistic.matchResultMap[WinnerAmountCategory.FORTH]).isEqualTo(1)
        assertThat(statistic.matchResultMap[WinnerAmountCategory.FIFTH]).isEqualTo(1)
        assertThat(statistic.matchResultMap[WinnerAmountCategory.ZERO]).isEqualTo(2)
    }

    @Test
    fun 수익률_구하기() {
        // given
        lottos.lottoList.addAll(
            listOf(Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(10),LottoNumbers.of(9),LottoNumbers.of(8),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(10),LottoNumbers.of(9),LottoNumbers.of(8),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(10),LottoNumbers.of(9),LottoNumbers.of(8),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(9),LottoNumbers.of(8),LottoNumbers.of(7))),
                Lotto(listOf(LottoNumbers.of(1),LottoNumbers.of(2),LottoNumbers.of(10),LottoNumbers.of(9),LottoNumbers.of(8),LottoNumbers.of(7)))
            )
        )
        // when then
        statistic.confirmOfLotto(lottos, winnerNumbers)
        assertThat(statistic.rateOfReturn(5000)).isEqualTo(1000.0)
    }
}
