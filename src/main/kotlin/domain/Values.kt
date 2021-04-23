package domain

class Values(private val splitString: List<String>) {

    lateinit var values: List<Value>

    init {
            values = splitString.map { Value(it) }
    }
}
