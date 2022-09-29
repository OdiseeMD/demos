fun main() {
    var shape: Shape = Square(4.0)

    println("shape had a area of ${shape.calculateArea()}")

    shape = Circle(4.0)

    println("shape had a area of ${shape.calculateArea()}")

}

interface Shape {
    val name: String
    fun calculateArea(): Double
}

class Square(val side: Double) : Shape {
    override val name = "Square"

    override fun calculateArea(): Double {
        return side * side
    }
}

open class Circle(val radius: Double) : Shape {
    override val name = "Circle"

    override fun calculateArea(): Double {
        return radius * radius * Math.PI
    }

    open fun calculateOmtrek(): Double {
        return 2 * radius * Math.PI
    }
}

class Ovaal : Circle(2.0) {
    override fun calculateOmtrek(): Double {
        return 0.0
    }

    override fun calculateArea(): Double {
        return 0.0
    }
}