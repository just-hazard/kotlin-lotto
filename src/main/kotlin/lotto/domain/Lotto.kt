package lotto.domain

class Lotto(inputNumbers: List<Number>) {
    // 6자리 번호를 들고 있는 Number List 객체
    private var numbers = mutableListOf<Number>()

    init {
      numbers = inputNumbers.sortedBy { it.number }.toMutableList()
    }

    fun getNumbers() : List<Number> {
        return numbers
    }
}
