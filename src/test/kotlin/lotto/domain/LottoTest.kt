package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    private lateinit var numbers: Lotto

    @BeforeEach
    fun setUp() {
        numbers = Lotto(mutableListOf(Number(1), Number(3), Number(2), Number(6), Number(5), Number(4)))
    }

    @Test
    fun 로또_사이즈_확인() {
        assertThat(numbers.getNumbers().size).isEqualTo(6)
    }

    @ParameterizedTest
    @CsvSource(value = ["0,1","1,2","2,3","3,4","4,5","5,6", ], delimiter = ',')
    fun 정렬_확인(index: Int, number: Int) {
        assertThat(numbers.getNumbers()[index].number).isEqualTo(number)
    }
}
