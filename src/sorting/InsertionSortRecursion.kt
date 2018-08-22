package sorting

import java.util.*

/**
 * This file contains the recursive implementation of the insertion
 * sort algorithm same logic applies except the recursive function
 * call which is new
 */
fun main(args: Array<String>) {

    //random class initialized and seeded to produce same values all the time {11, 16, 6, 18, 1, 3, 17}
    val generator = Random(6)
    val array = IntArray(7) { generator.nextInt(20) }

    array.printArray() // array before sorting

    insertionSort(array, 1)

    array.printArray() // array after sorting
}

tailrec fun insertionSort(input: IntArray, firstUnsortedIndex: Int) {

    if(firstUnsortedIndex == input.lastIndex) return

    insert(input, firstUnsortedIndex)

    insertionSort(input, firstUnsortedIndex + 1)
}

fun insert(input: IntArray, firstUnsortedIndex: Int) {

    val insertElement = input[firstUnsortedIndex]

    var i = firstUnsortedIndex

    while (i > 0 && insertElement < input[i - 1]) {

        input[i] = input[i - 1]

        i--
    }

    input[i] = insertElement
}

