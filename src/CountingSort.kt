fun main(args: Array<String>) {

    val intArray = arrayOf(2, 5, 9, 8, 2, 8, 7, 10, 4, 3)

    intArray.printArray() // array before sorting

    countingSort(intArray, 2,  10) //count sort function call with minimum and maximum values of the array to be sorted

    intArray.printArray() //array after sorting

    /*
    * count array is not an in-place algorithm
    * time complexity of O(n) due to assumptions about the values to be sorted
    * unstable sort (implementation) stability can be achieved with extra steps*/
}

fun countingSort(input: Array<Int>, min: Int, max: Int) {

    if(min < 0 || max < 0) throw IndexOutOfBoundsException("neither min nor max value can be negative")

    /*create a counting array capable of holding all numbers within
    * the range of the minimum and maximum values inclusive*/
    val countArray = Array((max - min) + 1){0}

    /*for each element in the input array*/
    for (i in input){
        countArray[i - min]++ //increase the count array for each number found at it's position in the count array
    }

    var j = 0 // variable for keeping track of the number of elements copied back into the input array

    // for each value within the range of the given maximum and minimum values
    for (i in min .. max) {

        /*while the number of elements denoted in the count array for the given number
        *in the range is not zero( has finished copying to input)
        */
        while (countArray[i - min] > 0) {
            input[j++] = i //copy i to j and increment j
            countArray[i - min]-- // reduce the total count of the given element since it's been copied back to input
        }
    }
}