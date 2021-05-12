package domain

class Value(value: String?) {

    companion object {
        const val ZERO = 0
    }

    var number: Int = 0

    init {
        validateNullAndEmpty(value)
        validateParseInt(value)
        validatePositiveNumber()
    }

    private fun validateNullAndEmpty(value: String?){
        if(value.isNullOrEmpty()) {
            number = ZERO
        }
    }

    private fun validateParseInt(value: String?) {
        try {
            number = value?.toInt()!!
        } catch (illegalArgumentException: IllegalArgumentException) {
            throw IllegalArgumentException("정수로 변경할 수 없는 문자열입니다.")
        }
    }

    private fun validatePositiveNumber() {
        if(number < ZERO) {
            throw IllegalArgumentException("양수만 입력이 가능합니다.")
        }
    }
}
