package lotto.domain

class Number(var number: Int) {

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }

    init {
        validateLottoNumberRange()
    }

    private fun validateLottoNumberRange() {
        if(LOTTO_MIN_NUMBER > number || LOTTO_MAX_NUMBER < number) {
            throw IllegalArgumentException("1-45 범위 초과 숫자입니다.")
        }
    }

    fun isSameNumber(number: Number, winnerNumber: Number) : Boolean {
        return number == winnerNumber
    }
}
