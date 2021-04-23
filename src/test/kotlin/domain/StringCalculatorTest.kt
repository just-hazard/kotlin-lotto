package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun 문자열_더하기() {
        val calculator = StringCalculator("1,2,3")
        assertThat(calculator.sumStringNumber()).isEqualTo(6)
    }

    @Test
    fun 커스텀_기호_문자열_더하기() {
        val calculator = StringCalculator("//;\n1;2;3")
        assertThat(calculator.sumStringNumber()).isEqualTo(6)
    }
}
