package lotto.domain

class LottoNumbers {

    companion object {
        private val lottoNumbers = mutableMapOf<Int, Number>()
        fun collectionLottoNumbers() : MutableCollection<Number> {
            return lottoNumbers.values
        }

        init {
            for(index in Number.LOTTO_MIN_NUMBER..Number.LOTTO_MAX_NUMBER) {
                lottoNumbers[index] = Number(index)
            }
        }
    }

    fun numberSize(): Int {
        return lottoNumbers.size
    }
}
