package domain


class SplitStringDelimiter {

    companion object {
        private const val PATTERN_GROUP_TWO = 2
        private val DEFAULT_PATTERN = "[,:]".toRegex()
        private val CUSTOM_DELIMITER_PATTERN = "(.)\n(.*)".toRegex()
    }

    fun splitString(inputValue: String): List<String> {
        if(CUSTOM_DELIMITER_PATTERN.containsMatchIn(inputValue)) {
            val matchResult = CUSTOM_DELIMITER_PATTERN.find(inputValue)
            return matchResult!!.groupValues[PATTERN_GROUP_TWO].split(matchResult.value[0])
        }
        return inputValue.split(DEFAULT_PATTERN)
    }
}
