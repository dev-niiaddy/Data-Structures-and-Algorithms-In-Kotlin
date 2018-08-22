package sorting

fun main(args: Array<String>) {

    val array = Array(7) {
        it + 1
    }
    array[0] = 20
    array[1] = 35
    array[2] = -15
    array[3] = 7
    array[4] = 55
    array[5] = 1
    array[6] = -22

    array.forEach {
        println(it)
    }

}