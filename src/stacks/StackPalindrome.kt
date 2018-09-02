package stacks

fun main(args: Array<String>) {

    val stringA = "I did, did I?"
    val stringB = "Race car"
    val stringC = "hello"
    val stringD = "Don't nod"
    val stringF = "Was it a car or a cat i saw"

    println("$stringA : is a palindrome? ${isPalindrome(stringA)}")
    println("$stringB : is a palindrome? ${isPalindrome(stringB)}")
    println("$stringC : is a palindrome? ${isPalindrome(stringC)}")
    println("$stringD : is a palindrome? ${isPalindrome(stringD)}")
    println("$stringF : is a palindrome? ${isPalindrome(stringF)}")
}

fun isPalindrome(string: String): Boolean {
    val stack = LinkedStack<Char>() //wrapper around linked list class to only allow stack operations
    string.forEach { char ->
        if(char.isLetter()) stack.push(char.toLowerCase())
    }

    stack.printStack()

    string.forEach { char ->
        if (char.isLetter() && char.toLowerCase() != stack.pop())  return false
    }
    return true
}