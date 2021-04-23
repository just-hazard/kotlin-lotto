package domain

class Values(splitString: List<String>) {

    var values: List<Value> = splitString.map { Value(it) }

    fun sum(): Int {
        return values.map { it.number }
            .reduce{total, number -> total + number}
    }

}
