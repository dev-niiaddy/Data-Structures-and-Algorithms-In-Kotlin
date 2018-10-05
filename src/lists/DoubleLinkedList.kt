package lists

import java.lang.IllegalArgumentException

class DoubleLinkedList<T> {

    private var head: DoubleNode<T>? = null
    private var tail: DoubleNode<T>? = null

    var size: Int = 0
        private set

    val isEmpty get() = size <= 0

    fun addToFront(node: T) {

        val newNode = DoubleNode(node)

        if (head == null) {
            tail = newNode
        } else {
            head?.previous = newNode
            newNode.next = head
        }

        head = newNode

        size++
    }

    fun addToEnd(node: T) {

        val newNode = DoubleNode(node)

        if (tail == null) {
            head = newNode
        } else {
            tail?.next = newNode
            newNode.previous = tail
        }

        tail = newNode
        size++
    }

    fun addBefore(add: T, before: T): Boolean {

        if (head == null) return false

        val newNode = DoubleNode(add)

        var current = head

        while (current != null) {

            if (current.node == before) {

                newNode.previous = current.previous
                newNode.next = current

                current.previous?.next = newNode
                current.previous = newNode

                size++
                return true
            }

            current = current.next
        }

        return false
    }

    fun addAt(node: T, position: Int) {

        if (isEmpty || position > size) throw IllegalArgumentException(
                "Position: $position cannot be greater than the size: $size of the list")

        var currentNode = head

        for (i in 0 until  position) currentNode = currentNode?.next

        val newNode = DoubleNode(node)
        currentNode?.previous?.next = newNode
        newNode.next = currentNode
        currentNode?.previous = newNode
    }

    fun removeFromFront(): DoubleNode<T>? {

        if (isEmpty) return null
        val removedNode = head
        val nextNode = head?.next

        if (nextNode == null) tail = null
        else nextNode.previous = null

        head = nextNode
        size--

        removedNode?.next = null

        return removedNode
    }

    fun removeFromEnd(): DoubleNode<T>? {

        if (isEmpty) return null

        val removedNode = tail
        val previousTail = tail?.previous

        if (previousTail == null) tail = null
        else previousTail.next = null

        tail = previousTail
        size--

        removedNode?.previous = null

        return removedNode
    }

    fun removeAt(position: Int) {

        if (isEmpty || position > size) throw IllegalArgumentException(
                "Position: $position cannot be greater than the size: $size of the list")


        var currentNode = head

        for (i in 0 until  position) currentNode = currentNode?.next

        currentNode?.previous?.next = currentNode?.next
        currentNode?.next?.previous = currentNode?.previous
    }


    fun printList() {

        var current = head
        print("HEAD -> ")

        while (current != null) {
            print("$current <-> ")
            current = current.next
        }

        println("null")
    }

}

fun main(args: Array<String>) {
    val james = Employee("James", "Hitch Cock", 1)
    val rosa = Employee("Rosa", "Diaz", 22)
    val raymond = Employee("Raymond", "Holt", 235)
    val amy = Employee("Amy", "Santiago", 442)


    val doubleLinkedList = DoubleLinkedList<Employee>()

    doubleLinkedList.addToFront(james)
    doubleLinkedList.addToFront(rosa)
    doubleLinkedList.addToFront(raymond)
    doubleLinkedList.addToFront(amy)

    doubleLinkedList.printList() // print list
    println("linked list size: ${doubleLinkedList.size}")
    println("Linked list is empty? ${doubleLinkedList.isEmpty}")

    val billEnd = Employee("Bill", "End", 234)
    doubleLinkedList.addToEnd(billEnd)
    doubleLinkedList.printList()
    println("the size of the list ${doubleLinkedList.size}")
    doubleLinkedList.printList()


    println("The removed node ${doubleLinkedList.removeFromFront()} \nsize: ${doubleLinkedList.size}")
    doubleLinkedList.printList()

    println("The removed node ${doubleLinkedList.removeFromEnd()} \nsize: ${doubleLinkedList.size}")
    doubleLinkedList.printList()

    val tyrion = Employee("Tyrion", "Lanister", 4772)

    doubleLinkedList.addBefore(tyrion, rosa)
    doubleLinkedList.printList()

    val positionEmployee = Employee("James", "Gosling", 1452)
    doubleLinkedList.addAt(positionEmployee, 2)
    println("Added at position 2")
    doubleLinkedList.printList()
    println("Removed at position 0")
    doubleLinkedList.removeAt(0)
    doubleLinkedList.printList()
}