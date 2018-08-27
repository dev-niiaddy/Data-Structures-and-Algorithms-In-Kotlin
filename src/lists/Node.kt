package lists

class Node<T>(private val node: T) {

    var next: Node<T>? = null

    override fun toString(): String {
        return  node.toString()
    }

}