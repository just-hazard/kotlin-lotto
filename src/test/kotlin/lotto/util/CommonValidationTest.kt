package lotto.util

import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CommonValidationTest {

    @Test
    fun `6개_이하일경우_예외처리`() {
        Assertions.assertThatThrownBy {
            val lottoNumbers = LottoNumbers.collectionLottoNumbers().distinct()
            CommonValidation.validationLengthCheck(mutableListOf(lottoNumbers[3], lottoNumbers[1], lottoNumbers[2], lottoNumbers[6], lottoNumbers[5]))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("6자리 이하 또는 이상입니다.")
    }

    @Test
    fun 중복번호_예외처리() {
        Assertions.assertThatThrownBy {
            val lottoNumbers = LottoNumbers.collectionLottoNumbers().distinct()
            CommonValidation.validationOverlap(mutableListOf(lottoNumbers[3], lottoNumbers[3], lottoNumbers[1], lottoNumbers[2], lottoNumbers[6], lottoNumbers[5]))
        }.isInstanceOf(RuntimeException::class.java).hasMessage("중복 번호가 존재합니다.")
    }
}
