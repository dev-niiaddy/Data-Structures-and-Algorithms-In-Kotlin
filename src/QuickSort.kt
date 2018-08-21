import java.util.*

fun main(args: Array<String>) {
    //random class initialized and seeded to produce same values all the time {11, 16, 6, 18, 1, 3, 17}
    val generator = Random(6)
    val array = Array(7) { generator.nextInt(20) }

    array.printArray() //array before sorting

    quickSort(array, 0, array.size) //quick sort function call to sort array

    array.printArray() // array after sorting


    /*
    * quick sort is an in-place algorithm,
    * it has a time complexity of O(n log n) - log of base 2
    * and is an unstable algorithm*/
}


/*
* method for performing the quick sort algorithm
* end is one greater than the last valid index of the input array*/
fun quickSort(input: Array<Int>, start: Int, end: Int) {
    if (end - start < 2) return //if the array has a size of 1 then is already sorted

    /*find the index of the pivot after sorting
    * by calling the partition method which does the sorting based on the
    * pivot element*/
    val pivotIndex = partition(input, start, end)

    quickSort(input, start, pivotIndex) //array  to left side of the pivot to be quick sorted
    quickSort(input, pivotIndex + 1, end) //array to the right side of the pivot
}

fun partition(input: Array<Int>, start: Int, end: Int):Int {
    //using the first element as the pivot
    val pivot = input[start]
    var i = start
    var j = end

    //while i and j have not crossed each other
    while (i < j) {

        //empty loop body
        while (i < j && input[--j] >= pivot);  //loop to find element less than the pivot but to the right side of it

        if (i < j) input[i] = input[j] //if previous loop ended due to finding an element less than pivot then put it i

        //empty loop body
        while (i < j && input[++i] <= pivot); //loop to find element greater than the pivot but to the left side of it

        if (i < j) input[j] = input[i] //if previous loop ended due to finding an element greater than pivot then put it j


        //NB: no loss of data due to switch between i and j
    }

    input[j] = pivot
    return  j
}