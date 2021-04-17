package domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

class ValueTest {

    @Test
    fun 널_및_빈값_전달시_0리턴확인() {
        val nullValue = Value(null)
        assertThat(nullValue.number).isEqualTo(0)

        val emptyValue = Value("")
        assertThat(emptyValue.number).isEqualTo(0)
    }

    @Test
    internal fun 정수인지_판별() {
        Assertions.assertThatThrownBy {
            val stringValue = Value("String")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("정수로 변경할 수 없는 문자열입니다.")
    }

    @Test
    internal fun 양수인지_판별() {
        Assertions.assertThatThrownBy {
            val positiveNumber = Value("-1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("양수만 입력이 가능합니다.")
    }
}
