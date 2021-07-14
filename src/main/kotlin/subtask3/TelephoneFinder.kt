package subtask3

class TelephoneFinder {


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val num = number.toIntOrNull()
        if (num == null || num < 0) return null
        val newList = mutableListOf<String>()
        val numInt = number
            .split("")
            .toMutableList()

        numInt.removeAll { it == "" }

        numInt.forEachIndexed { index, it ->
            changeAllNaiborChar(number, index, collection[it]!!, newList)
        }
        return newList.toTypedArray()
    }

    private fun changeAllNaiborChar(
        number: String,
        index: Int,
        array: Array<String>,
        newArray: MutableList<String>
    ) {
        for (element in array) {
            newArray.add(changeChar(number, index, element))
        }
    }

    private fun changeChar(number: String, index: Int, charToReplace: String) =
        number.substring(0, index) + charToReplace + number.substring(index + 1)

    companion object {
        val collection = mapOf(
            "1" to arrayOf("2", "4"),
            "2" to arrayOf("1", "3", "5"),
            "3" to arrayOf("2", "6"),
            "4" to arrayOf("1", "5", "7"),
            "5" to arrayOf("2", "4", "6", "8"),
            "6" to arrayOf("3", "5", "9"),
            "7" to arrayOf("4", "8"),
            "8" to arrayOf("5", "7", "9", "0"),
            "9" to arrayOf("6", "8"),
            "0" to arrayOf("8")
        )
    }
}