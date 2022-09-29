fun main() {
    val number = 7

    println("$number is prime: ${number.isPrime()}")
    println("$number is even: ${number.isEven()}")

    val house = House("Red", 10, false)
    house.print()

    println("1234".containsNumbers())
    println("abcs".containsNumbers())
}

fun Int.isPrime(): Boolean {
    var isPrime = true
    for (i in 2..this - 1) {
        if (this % i == 0) {
            isPrime = false
        }
    }
    return isPrime
}

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun House.print() {
    println("House ${this.color} example")
}

fun String.containsNumbers(): Boolean {
    val digit = this.map { it.isDigit() }
    return digit.contains(true)
}