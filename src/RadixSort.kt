fun main(args: Array<String>) {
    val radixArray = intArrayOf(4725, 4586, 1330, 8792, 1594, 5729)

    radixArray.printArray() // array before sorting

     radixSort(radixArray, 10, 4) // function for perform radix sorting on the given array

    radixArray.printArray() // array after sorting

    /*
    * all data must have the same width and radix for the algorithm to hold
    * radix sort is a stable algorithm (stability makes the algorithm work)
    * time complexity of O(n) since we make assumption about the data, yet
    * usually runs slower than O(n log n) because of the overhead involved
    * Implementation not done in-place but can be performed in-place
    */
}

/*
* radix sort function to sort the entire array
* [input] the given array to be sorted
* [radix] of all elements in the array
* [width] the width of all element in the array*/
fun radixSort(input: IntArray, radix: Int, width: Int) {

    /*for each element at a given position the width
    * of the array elements, perform a single radix sort operation on the array*/
    for (i in 0 until width) {
        /*function for performing a single sort for
        * each position in teh width*/
        radixSingleSort(input, i, radix)
    }
}

/*
*  function to perform a single radix sort operation
*  for the position specified*/
fun radixSingleSort(input: IntArray, position: Int, radix: Int) {

    val countArray = IntArray(radix) //create a new counting array for each possible value in the radix

    /* for each value within the array for the specified position
    * in the array set the count for the returned value by get digit
    */
    for (value in input) {
        countArray[getDigit(position, value, radix)]++
    }

    /*adjust the counts to reflect how many times a given digit or less
    * exist in the array*/
    for (j in 1 until radix) {
        countArray[j] += countArray[j - 1]
    }

    val temp = IntArray(input.size) // temporary array for sorting

    /*
     * reduce count at a given position in the array and insert it
     * into it's correct index in the temp array using the adjusted counts,
     * we insert from right to left to create stability (preserve the
     * relative positioning of duplicate items)
     */
    for (tempIndex in input.lastIndex downTo  0) {
        temp[ --countArray[getDigit(position, input[tempIndex], radix) ] ] = input[tempIndex]
    }

    /*
     *copy element back into the input array
     */
    for (tempIndex in 0 .. input.lastIndex) {
        input[tempIndex] = temp[tempIndex]
    }
}

/*
* function to calculate the values contained at a given position in a given value*/
fun getDigit(position: Int, value: Int, radix: Int): Int {
    return value / Math.pow(radix.toDouble(), position.toDouble()).toInt() % radix
}