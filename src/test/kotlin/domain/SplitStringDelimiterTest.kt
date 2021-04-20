package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SplitStringDelimiterTest {

    private val splitStringDelimiter = SplitStringDelimiter()

    @ParameterizedTest
    @CsvSource(value = ["1,2,3=1,2,3", "4,5:6=4,5,6"], delimiter = '=')
    fun 디폴트_구분자_테스트(input: String, result: String) {
        assertThat(splitStringDelimiter.splitString(input)).isEqualTo(result.split(","))
    }

    @Test
    fun 커스텀_구분자_테스트() {
        val input = "//;\n1;2;3"

        val result = "1,2,3"
        assertThat(splitStringDelimiter.splitString(input)).isEqualTo(result.split(","))
    }
}
