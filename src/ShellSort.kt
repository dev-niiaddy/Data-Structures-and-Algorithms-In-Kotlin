import java.util.*

fun main(args: Array<String>) {
    //random class initialized and seeded to produce same values all the time {11, 16, 6, 18, 1, 3, 17}
    val generator = Random(6)
    val array = Array(7) { generator.nextInt(20) }

    array.printArray() //array before sorting

    /**
     * simple gap value calculated by dividing the array into 2*/
    var gap = array.size / 2

    /**
     * if the gap value is greater than zero creates a range from gap to to 1
     * at gap 1 we're doing an insertion sort and since
     * the array has had preliminary sorting done, less shifting is required to
     * sort the array on the insertion step
     * @see InsertionSort.kt
     * */
    while (gap > 0) {

        /**loop from gap to last element in the array*/
        for (i in gap..array.lastIndex) {

            /**copy element from current index (the value at i in the array)*/
            val newElement = array[i]

            var j= i   //initialize j to i

            /**
             * while gap newElement is greater than the value at
             * j minus gap and we haven't hit the front of the
             * array (since we check j minus gap and if j is less than gap we'll
             * gave a negative index, thus j must always be greater than or
             * equal to gap for the loop to execute)*/
            while (j >= gap && array[j - gap] > newElement) {
                /**
                 * then copy from j minus gap
                 * into j if value at j minus gap is greater than the one at i
                 * or at newElement*/
                array[j] = array[j - gap]
                j -= gap
            }

            /*insert new element at j
            * if shifting occurred then j will be the insertion point for newElement
            * else j will be put where it was picked*/
            array[j] = newElement
        }

        //reduce gap by dividing by 2
        gap /= 2
    }

    array.printArray()//array after sorting

    //time complexity of (almost linear due to shifting reduced by the gap comparison)
    //but in worst case is an n²
    //shell sort can be applied to bubble sort
    //unstable sorting algorithm
}