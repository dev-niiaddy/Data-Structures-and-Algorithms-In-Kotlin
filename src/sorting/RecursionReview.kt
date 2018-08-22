package sorting

fun main(args: Array<String>) {

    //prints the result of the given factorial [5] in this case
    println(factorialRecursive(5))

    println(factorialIterative(5))

}

//method to calculate factorial recursively
fun factorialRecursive(value: Int): Int {
    /**=factorial of negative numbers are undefined so throw an exception when called with a
    negative value*/
    if (value < 0) throw IllegalStateException("Factorial of negative numbers are undefined")

    return when { //when clause with return
        (value == 1 || value == 0) -> 1 //return 1 when value is 1 or zero
        else -> value * factorialRecursive(value - 1) //else call factorial with one less the given value
    }

}

fun factorialIterative(value: Int): Int {
    if (value < 0) throw IllegalStateException("Factorial of negative numbers are undefined")

    var result = 1
    /*returns an empty range when the value is 0
    * so the loop fails to execute so result will still be 1*/
    for (i in value downTo 1) result *= i

    return result
}