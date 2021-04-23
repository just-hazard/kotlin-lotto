package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValuesTest {

    @Test
    fun 문자열_객체들_생성() {
        val values = Values(listOf("1","2","3"))
        assertThat(values.values.size).isEqualTo(3)
    }
}
