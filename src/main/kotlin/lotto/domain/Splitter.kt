package lotto.domain

class Splitter {
    companion object {
        private const val COMMA = ","
        var numbers : MutableList<Number> = mutableListOf()

        fun splitStringNumbers(inputNumbers: String) : List<Number> {
            return createWinnerNumbers(inputNumbers.trim().split(COMMA))
        }

        private fun createWinnerNumbers(numberList: List<String>): List<Number> {
            numberList.forEach {
                numbers.add(LottoNumbers.of(it.toInt()))
            }
            return numbers
        }
    }
}
