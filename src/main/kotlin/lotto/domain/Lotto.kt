package lotto.domain

import lotto.util.CommonException.Companion.overlapException

class Lotto(var inputNumbers: List<Number>) {
    // 6자리 번호를 들고 있는 Number List 객체
    private var numbers = mutableListOf<Number>()

    init {
        // 공통으로 빼기
        validationLengthCheck()
        numbers = inputNumbers.sortedBy { it.number }.toMutableList()
        validationOverlap()
    }

    private fun validationOverlap() {
        if(numbers.distinct().size != RandomNumber.LOTTO_NUMBER_LENGTH_MAX) {
            throw overlapException("중복 번호가 존재합니다.")
        }
    }

    private fun validationLengthCheck() {
        if(inputNumbers.size != RandomNumber.LOTTO_NUMBER_LENGTH_MAX) {
            throw IllegalArgumentException("6자리 이하 또는 이상입니다.")
        }
    }

    fun getNumbers() : List<Number> {
        return numbers
    }
}
