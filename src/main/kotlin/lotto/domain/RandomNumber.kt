package lotto.domain

class RandomNumber {

    companion object {
        const val LOTTO_NUMBER_LENGTH_MIN = 0
        const val LOTTO_NUMBER_LENGTH_MAX = 6
    }

    fun createRandomNumbers(): List<Number> {
        val numbers = LottoNumbers.collectionLottoNumbers().shuffled()
        return numbers.subList(LOTTO_NUMBER_LENGTH_MIN, LOTTO_NUMBER_LENGTH_MAX)
    }
}
