package lists

class SingleLinkedList<T> {

    internal var head: Node<T>? = null

    var size: Int = 0
        internal set

    val isEmpty
        get() = head == null

    fun addToFront(node: T) {

        val newNode = Node(node)
        newNode.next = head
        head = newNode

        size++
    }

    fun removeFromFront(): Node<T>? {

        if (isEmpty) return null

        val removedNode = head

        head = removedNode?.next
        size--

        removedNode?.next = null

        return removedNode
    }


    fun printList() {

        var current = head
        print("HEAD -> ")

        while (current != null) {
            print("$current -> ")
            current = current.next
        }

        println("null")
    }

}

//extension function for adding single linked list of integers in sorted order
fun SingleLinkedList<Int>.insertSorted(value: Int) {

    //assumption: list is already sorted
    when {
        isEmpty -> return addToFront(value)
        head!!.node > value -> return addToFront(value)
    }

    //find the insertion point
    val newNode = Node(value)
    var previousNode = head
    var currentNode = head?.next

    while (currentNode != null && currentNode.node < value) {
        previousNode = currentNode
        currentNode = currentNode.next
    }

    newNode.next = currentNode
    previousNode?.next = newNode
    size++
}

fun main(args: Array<String>) {

    val james = Employee("James", "Hitch Cock", 1)
    val rosa = Employee("Rosa", "Diaz", 22)
    val raymond = Employee("Raymond", "Holt", 235)
    val amy = Employee("Amy", "Santiago", 442)

    val linkedList = SingleLinkedList<Employee>()

    linkedList.addToFront(james)
    linkedList.addToFront(rosa)
    linkedList.addToFront(raymond)
    linkedList.addToFront(amy)

    linkedList.printList() // print list
    println("linked list size: ${linkedList.size}")
    println("Linked list is empty? ${linkedList.isEmpty}")
    println("The removed node ${linkedList.removeFromFront()} size: ${linkedList.size}")
    linkedList.printList()

    val integerList = SingleLinkedList<Int>()
    integerList.insertSorted(4)
    integerList.insertSorted(2)
    integerList.insertSorted(1)
    integerList.insertSorted(5)
    integerList.insertSorted(4)

    integerList.printList()

}