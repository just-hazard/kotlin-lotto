package lotto.domain

import lotto.util.CommonValidation

class Lotto(var inputNumbers: List<Number>) {
    // 6자리 번호를 들고 있는 Number List 객체
    private var numbers = mutableListOf<Number>()

    init {
        numbers = inputNumbers.sortedBy { it.number }.toMutableList()
        CommonValidation.validationLengthCheck(numbers)
        CommonValidation.validationOverlap(numbers)
    }

    fun getNumbers() : List<Number> {
        return numbers
    }

    override fun toString(): String {
        return "$numbers"
    }
}
