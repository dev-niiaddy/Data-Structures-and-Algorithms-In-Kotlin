package sorting

fun main(args: Array<String>) {
    //initialize an array of integers[ an array of size 7 last index of 6]
    val array = arrayOf(20, 35, -15, 7, 55, 1, -22)

    /**
     * the size of the unsorted array is equal to that of the whole array
     * and hence the indices
     */
    var unsortedIndex = array.lastIndex

    array.printArray() //array before sorting
    /**
     * continue looping since sorting is only complete if the
     * size of the unsorted array is 0*/
    while (unsortedIndex != 0){

        /*loop till you hit one below the unsorted index
        * because we compare the current loop variable(index)
        * with the one above it*/
        for (i in 0 until unsortedIndex) {

            /**
             * if the current element is greater than the one
             * to the right of it then sorting.swap their positions
            */
            if(array[i] > array[i+1]){
                array.swap(i, i+1)
            }
        }
        /**
         *after each iteration reduce the last index
         * of the unsorted array cos the largest will have
         * bubbled to the top or the right most end of the array
        */
        unsortedIndex--
    }

    //print out the sorted array
    array.printArray()

    //time complexity of n²
    //stable sorting algorithm
}