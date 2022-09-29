import kotlin.math.PI


fun main(args: Array<String>) {
//    helloWorld( 30,"Matthias", "Aalst")
//    helloWorld(82)
//
//    helloWorld(name = "Jef", age=34)
//
//    println(oppervlakteCirkel(1.0))

    var waterFilter: (Int) -> Int
    waterFilter = { level: Int -> level / 2 }
    val result = waterFilter(20)

    val convertToDouble = { number: Int -> number.toDouble() }


    println(result)

    val result3 = divideBy2(4, convertToDouble)

    val result4 = divideBy2(4, ::convertToDouble2)

    val result2 = divideBy2(4) { number ->
        number.toDouble()
    }

    repeat(5) {
        println("test")
    }

    val action = { x: Int ->
        println("MyTest")
    }

    myRepeat(5, action)

}

fun convertToDouble2(number: Int): Double {
    return number.toDouble()
}

fun myRepeat(i: Int, action: (Int) -> Unit) {
    for (x in 1..i) {
        action(x)
    }
}

fun divideBy2(value: Int, converter: (Int) -> Double): Double {
    return converter(value) / 2.0
}

fun helloWorld2(age: Int, name: String = "Vreemdeling", geboortePlaats: String = "Brussel") =
    println("Hello $name, ik ben $age jaar oud")

fun square(x: Int) = x * x

fun oppervlakte(x: Int, y: Int) = x * y

fun oppervlakteCirkel(r: Double) = r * r * PI

