import demo.Street

data class Student(var firstname: String, var lastname: String)

fun main() {
    val s1 = Student("Matthias", "Druwé")
    val s2 = Student("Matthias", "Druwé")

    val s3 = s1.copy(firstname = "Sarah")
    println(s1 == s2)
    println(s2)

    val pair1 = s1 to 10
    val triple = Triple(s1, s2, s3)
    val studentList = listOf(1 to s1, 2 to s2, 3 to s3)
    println(studentList)

    val pants = Pants(Colors.BLUE)

    println(Calculator.add(5, 3))
    println(Rectangle.name)
    println(Rectangle(5.0, 2.0).calculateArea())
    Street()
}

enum class Colors {
    RED, GREEN, YELLOW, BLUE
}

class Pants(val color: Colors)

fun Colors.rgb(): String {
    when (this) {
        Colors.BLUE -> return "0000FF"
        else -> return ""
    }
}

object Calculator {
    fun add(x1: Int, x2: Int) = x1 + x2
}

class Rectangle(val side1: Double, val side2: Double) {
    companion object {
        val name = "Rechthoek"
    }

    fun calculateArea() = side1 * side2
}