package lotto.util

import lotto.domain.Number
import lotto.domain.RandomNumber

class CommonValidation {

    companion object {
        fun validationLengthCheck(numbers: MutableList<Number>) {
            if(numbers.size != RandomNumber.LOTTO_NUMBER_LENGTH_MAX) {
                throw IllegalArgumentException("6자리 이하 또는 이상입니다.")
            }
        }

        fun validationOverlap(numbers: MutableList<Number>) {
            if(numbers.distinct().size != RandomNumber.LOTTO_NUMBER_LENGTH_MAX) {
                throw CommonException.overlapException("중복 번호가 존재합니다.")
            }
        }
    }

}
