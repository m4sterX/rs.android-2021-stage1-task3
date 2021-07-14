package subtask2

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number, sqrtWithLong(number.toLong()))
    }

    private fun decompose(x: Int, sqrt: Long): Array<Int>? {
        for (i in x - 1 downTo 1) {
            if (sqrtWithLong(i.toLong()) == sqrt)
                return arrayOf(i)
            val difference = sqrt - sqrtWithLong(i.toLong())
            if (difference > 0) {
                val arr = decompose(i, difference)
                if (arr != null)
                    return arr.plus(i)
            }
        }
        return null
    }

    private fun sqrtWithLong(i: Long) = (i * i)
}