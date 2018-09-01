package stacks

import lists.Employee
import java.util.*

@Suppress("UNCHECKED_CAST")
class ArrayStack<T>(capacity:Int = 10) {

    private var stack: Array<Any?> = Array(capacity) { null }
    private var top = 0
    val isEmpty get() = top == 0
    val size get() = top

    fun push(value: T) {
        if (top == stack.size) {
            //need to resize the backing array
            val newArray = Array<Any?>(stack.size * 2) { null }
            System.arraycopy(stack, 0, newArray, 0, stack.size)
            stack = newArray
        }

        stack[top++] = value
    }

    fun pop(): T {
        if (isEmpty) throw EmptyStackException()
        val  value = stack[--top] as T
        stack[top] = null
        return value
    }

    fun peek(): T{
        if (isEmpty) throw EmptyStackException()
        return stack[top - 1] as T
    }

    fun printStack() {
        for (i in top - 1 downTo 0) print("${stack[i] as T} ,")
        println()
    }
}

fun main(args: Array<String>) {
    val arrayStack = ArrayStack<Employee>(10)

    val james = Employee("James", "Hitch Cock", 1)
    val rosa = Employee("Rosa", "Diaz", 22)
    val raymond = Employee("Raymond", "Holt", 235)
    val amy = Employee("Amy", "Santiago", 442)

    arrayStack.push(james)
    arrayStack.push(rosa)
    arrayStack.push(raymond)
    arrayStack.push(amy)

    arrayStack.printStack()
    println(arrayStack.peek())
    println("Popped: --> ${arrayStack.pop()}")
    arrayStack.printStack()
}