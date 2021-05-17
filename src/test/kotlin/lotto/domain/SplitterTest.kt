package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SplitterTest {

    @Test
    fun 문자열_숫자_자르기() {
        Splitter.splitStringNumbers("1,2,3,4,5,6")
        assertThat(Splitter.numbers).containsExactly(LottoNumbers.of(1), LottoNumbers.of(2),LottoNumbers.of(3),LottoNumbers.of(4),LottoNumbers.of(5),LottoNumbers.of(6))
    }
}
