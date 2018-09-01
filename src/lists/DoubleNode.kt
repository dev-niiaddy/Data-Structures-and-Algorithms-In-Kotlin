package lists

class DoubleNode<T>(val node: T) {

    var next: DoubleNode<T>? = null
    var previous: DoubleNode<T>? = null

    override fun toString(): String {
        return node.toString()
    }

}
