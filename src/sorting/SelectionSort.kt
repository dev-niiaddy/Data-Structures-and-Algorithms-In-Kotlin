package sorting

import java.util.*

fun main(args: Array<String>) {

    //random class initialized and seeded to produce same values all the time {11, 16, 6, 18, 1, 3, 17}
    val generator = Random(6)
    val array = Array(7) { generator.nextInt(20) }


    array.printArray()//array before sorting

    /**outer loop for keeping track of the unsorted sorting.partition
    the loop begins from the last index and becomes smaller as we
    traverse and sort the array
     */
    for (lastUnsortedIndex in array.lastIndex downTo  1) {

        //we start traversing the array assuming the greatest element exists at index 0
        var greatest = 0

        //loop from index 1 to lastUnsorted Index
        for (i in 1..lastUnsortedIndex) {

            /*if an element is greater than the one stored at the index of the greatest variable,
            keep track of that variable as the greatest instead*/
            if (array[i] > array[greatest]) {
                greatest = i
            }

            /*when i is equal to the last unsorted index sorting.swap the two values
            at index greatest and lastUnsortedIndex
            NB: look at the implementation of extension function in sorting.swap in BubbleSort.kt
            */
            if (i == lastUnsortedIndex) {
                array.swap(greatest, lastUnsortedIndex)
            }
        }

        /*at the last unsorted index has decremented by 1 and the whole process is repeated
        again until the array is fully sorted(when the lastUnsorted index is equal to 1)*/
    }

    //print out the sorted array
    array.printArray()

    //time complexity of n²
    //unstable sorting algorithm
}