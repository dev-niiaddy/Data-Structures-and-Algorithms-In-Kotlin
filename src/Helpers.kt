fun <T> Array<T>.swap(i: Int, j: Int){
    if (i == j) return

    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}