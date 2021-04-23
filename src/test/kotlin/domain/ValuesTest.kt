package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ValuesTest {

     private lateinit var values: Values

    @BeforeEach
    fun setUp() {
        values = Values(listOf("1","2","3"))
    }

    @Test
    fun 문자열_객체들_생성() {
        assertThat(values.values.size).isEqualTo(3)
    }

    @Test
    fun 숫자_더하기() {
        assertThat(values.sum()).isEqualTo(6)
    }
}
