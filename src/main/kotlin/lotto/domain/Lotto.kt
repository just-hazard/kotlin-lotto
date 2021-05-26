package lotto.domain

import lotto.util.CommonValidation

class Lotto(inputNumbers: List<Number>) {

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
