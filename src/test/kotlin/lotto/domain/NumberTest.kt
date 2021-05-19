package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1 , 0, 46])
    fun 로또_지정범위_숫자인지_확인(number: Int) {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Number(number)
        }.withMessage("1-45 범위 초과 숫자입니다.")
    }

    @Test
    fun 같은번호_확인() {
        val number = Number(1)
        assertThat(number.isSameNumber(number, number)).isTrue
    }
}
