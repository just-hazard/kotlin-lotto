package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RandomNumberTest {

    private lateinit var randomNumber: RandomNumber

    @BeforeEach
    internal fun setUp() {
        randomNumber = RandomNumber()
    }
    @Test
    fun 번호_여섯자리_확인() {
        assertThat(randomNumber.createRandomNumbers().size).isEqualTo(6)
    }

    @Test
    fun 무작위_번호_확인() {
        val numbers = LottoNumbers.collectionLottoNumbers().distinct()
        assertThat(randomNumber.createRandomNumbers()).isNotEqualTo(numbers.subList(RandomNumber.LOTTO_NUMBER_LENGTH_MIN,
            RandomNumber.LOTTO_NUMBER_LENGTH_MAX))
    }
}
