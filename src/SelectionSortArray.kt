import java.util.*

fun main(args: Array<String>) {

    val generator = Random(6)
    val array = Array(7) { generator.nextInt(20) }


    for (lastUnsortedIndex in array.lastIndex downTo  0) {
        var greatest = 0

        for (i in 1..lastUnsortedIndex) {
            if (array[i] > array[greatest]) {
                greatest = i
            }
            if (i == lastUnsortedIndex) {
                array.swap(greatest, lastUnsortedIndex)
            }
        }
    }

    array.forEach { println(it) }
}