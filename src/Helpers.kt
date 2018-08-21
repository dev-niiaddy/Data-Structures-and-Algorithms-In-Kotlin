fun <T> Array<T>.swap(i: Int, j: Int){
    if (i == j) return

    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun <T> Array<T>.printArray(){
    this.forEach {
        print("$it,")
    }
    println()
}

fun IntArray.printArray(){

    this.forEach {
        print("$it,")
    }
    println()
}

