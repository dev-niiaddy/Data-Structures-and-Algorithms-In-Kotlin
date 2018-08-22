package sorting

fun main(args: Array<String>) {

    val stringArray = arrayOf("bcdef", "dbaqc", "abcde", "omadd", "bbbbb")

    stringArray.printArray() // array before sorting

    radixSort(stringArray, 5) // function for perform radix sorting on the given array

    stringArray.printArray() // array after sorting
}

fun radixSort(input: Array<String>, width: Int) {


    for (i in width - 1 downTo 0) {

        radixSingleSort(input, i)

    }
}


fun radixSingleSort(input: Array<String>, position: Int) {

    val countArray = IntArray(26)


    for (value in input) {
        countArray[getIndex(position, value)]++
    }


    for (j in 1 until 26) {
        countArray[j] += countArray[j - 1]
    }

    val temp = Array(input.size){""}


    for (tempIndex in input.lastIndex downTo 0) {
        temp[--countArray[getIndex(position, input[tempIndex])]] = input[tempIndex]
    }


    for (tempIndex in 0..input.lastIndex) {
        input[tempIndex] = temp[tempIndex]
    }
}

fun getIndex(position: Int, string: String): Int = string[position] - 'a'