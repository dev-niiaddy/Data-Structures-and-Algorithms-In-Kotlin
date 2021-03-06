package sorting

import java.util.*

fun main(args: Array<String>) {
    //random class initialized and seeded to produce same values all the time {11, 16, 6, 18, 1, 3, 17}
    val generator = Random(6)
    val array = Array(7) { generator.nextInt(20) }


    array.printArray() //array before sorting

    //beginning index for unsorted section of the array
    val firstUnsorted = 1

    /*loop to traverse the unsorted section of the array from 1 to the last index
    *6 in this case*/
    for (i in firstUnsorted..array.lastIndex) {
        /*
        * the first element in the unsorted array
        * */
        val newElement = array[i]
        var j = i //looping variable to traverse the sorted array from behind

        /*continue looping when the current element is greater than
        * the element we want to sorting.insert and we are not at zero
        * then continue shifting element to the next higher index*/
        while (j > 0 && (array[j - 1] > newElement)){
            array[j] = array[j-1]
            j--
        }
        /*if loop ends then the correct insertion point has been found and
        * created due to shifting and you can now sorting.insert the element*/
        array[j] = newElement
    }

    array.printArray()//array after sorting

    //time complexity of n²
    //stable sorting algorithm
}