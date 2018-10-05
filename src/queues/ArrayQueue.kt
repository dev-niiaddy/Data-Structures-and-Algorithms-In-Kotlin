package queues

import lists.Employee
import java.lang.System.arraycopy

@Suppress("UNCHECKED_CAST")
class ArrayQueue<T>(capacity: Int = 10) {

    private var queue = Array<Any?>(capacity) { null }
    private var front = 0
    private var back = 0
    val isEmpty get() = size == 0
    val size get() = back - front

    fun add(value: T) {
        if (size == queue.lastIndex) {
            val newArray = Array<Any?>(queue.size * 2) { null }
            arraycopy(queue, 0, newArray, 0, queue.size)
            queue = newArray
        }

        
        queue[back] = value //store value and increment back
        if(back < queue.lastIndex) back++
        else back = 0
    }

    fun remove(): T {
        if (isEmpty) throw NoSuchElementException()

        val value = queue[front] as T
        queue[front++] = null

        if (isEmpty) {
            front = 0; back = 0
        }

        return value
    }

    fun peek(): T {
        if (isEmpty) throw NoSuchElementException()

        return queue[front] as T
    }

    fun printQueue() {
        for (i in front until back) {
            println("${queue[i]} ,")
        }
    }
}


fun main(args: Array<String>) {
    val arrayQueue = ArrayQueue<Employee>(10)

    val james = Employee("James", "Hitch Cock", 1)
    val rosa = Employee("Rosa", "Diaz", 22)
    val raymond = Employee("Raymond", "Holt", 235)
    val amy = Employee("Amy", "Santiago", 442)

    arrayQueue.add(james)
    arrayQueue.add(rosa)
    arrayQueue.add(raymond)
    arrayQueue.add(amy)

    arrayQueue.printQueue()
    println("On top: --> ${arrayQueue.peek()}")
    println("Removed: --> ${arrayQueue.remove()}")
    arrayQueue.printQueue()
}