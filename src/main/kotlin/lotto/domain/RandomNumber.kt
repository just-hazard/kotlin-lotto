package lotto.domain

class RandomNumber {

    companion object {
        const val LOTTO_NUMBER_LENGTH_MIN = 0
        const val LOTTO_NUMBER_LENGTH_MAX = 6
    }

    val numbers = LottoNumbers.collectionLottoNumbers().shuffled()

    fun createRandomNumbers(): List<Number> {
        return numbers.subList(LOTTO_NUMBER_LENGTH_MIN, LOTTO_NUMBER_LENGTH_MAX)
    }
}
