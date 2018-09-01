package stacks

import lists.Employee
import java.util.*

class LinkedStack<T> {
    private val linkedList = LinkedList<T>()
    val isEmpty get() = linkedList.isEmpty()

    fun push(value: T) {
        linkedList.push(value)
    }
    fun pop() {
        linkedList.pop()
    }

    fun peek(): T {
        return linkedList.peek()
    }

    fun printStack() {
        val listIterator = linkedList.iterator()

        while (listIterator.hasNext()) {
            print("${listIterator.next()}, ")
        }
    }
}

fun main(args: Array<String>) {

    val stack = LinkedStack<Employee>()

    val james = Employee("James", "Hitch Cock", 1)
    val rosa = Employee("Rosa", "Diaz", 22)
    val raymond = Employee("Raymond", "Holt", 235)
    val amy = Employee("Amy", "Santiago", 442)

    stack.push(james)
    stack.push(rosa)
    stack.push(raymond)
    stack.push(amy)

    stack.printStack()
    println(stack.peek())
    println("Popped: --> ${stack.pop()}")
    stack.printStack()
}