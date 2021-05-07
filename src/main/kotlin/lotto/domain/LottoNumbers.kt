package lotto.domain

class LottoNumbers {

    companion object {
        private var lottoNumbers = mutableMapOf<Int, Number>()
    }

    init {
        for(index in 1..45) {
            lottoNumbers[index] = Number(index)
        }
    }

    fun numberSize(): Int {
        return lottoNumbers.size
    }
}
