package lotto.util

class CommonException {

    companion object {
        fun overlapException(message: String): Throwable {
            throw RuntimeException(message)
        }
    }
}
