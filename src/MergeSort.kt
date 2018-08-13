import java.util.*

fun main(args: Array<String>) {
    //random class initialized and seeded to produce same values all the time {11, 16, 6, 18, 1, 3, 17}
    val generator = Random(6)
    val array = Array(7) { generator.nextInt(20) }

    array.printArray() //print array before sorting

    mergeSort(array, 0, array.size) // merge sort function to sort the given array


    array.printArray() // array after sorting

    //the merge sort is not an in-place algorithm
    //O (n log n)(base 2) time complexity
    //stable algorithm
}


fun mergeSort(input: Array<Int>, start: Int, end: Int) {

    if (end - start < 2) return  //if we have a one element array then is already sorted

    val mid = (start + end) / 2  // find the midpoint of the array for logical splitting

    mergeSort(input, start, mid)  // split recursively the left side of the array
    mergeSort(input, mid, end) //split recursively the right section oft the array

    merge(input, start, mid, end)  // merge the left and right side of the array making sure they are sorted
}

fun merge(input: Array<Int>, start: Int, mid: Int, end: Int) {

    /*(Optimization)
    * If the first element in the right of the arrays to be merged
    * is greater than the last element in the left array then they both are in
    * their sorted positions**/
    if (input[mid - 1] <= input[mid]) return

    var i = start //variable for keeping track of the elements copied from the left side of the array into temp array
    var j = mid  //variable for keeping track of the elements copied from the right side of the array into temp array
    var tempIndex = 0 //variable for keeping track of the total elements copied from the left side of the array into temp array

    val temp = Array(end - start) { 0 }  //temp array for holding sorted element

    /*if we have not fully traversed the left array partition or the right
    * partition keep looping*/
    while (i < mid && j < end) {

        /*increase temp index after each copy*/
        temp[tempIndex++] = when {
            input[i] <= input[j] -> input[i++] //if input at i is less than input at j copy input at i and increase the value of i by 1
            else -> input[j++] //else copy the input at j since is less than input at i and increase the value of j by 1
        }
    }

    /*copy the element from the left partition into the final destination actual array
     *if mid - i equals to zero then there are no elements to copy from the left side
     * any elements left in right partition will already be in their sorted position
     * and hence we do not copy elements from the right side*/
    System.arraycopy(input, i, input, start + tempIndex, mid - i)

    /*copy the elements from the temp array into the input array to complete the sorting**/
    System.arraycopy(temp, 0, input, start, tempIndex)
}