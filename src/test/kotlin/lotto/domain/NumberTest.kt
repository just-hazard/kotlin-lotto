package lotto.domain

import org.assertj.core.api.Assertions
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
}
