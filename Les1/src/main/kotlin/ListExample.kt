fun main() {
    val colors = listOf("red", "red-orange", "dark red", "orange", "bright orange", "saffron")

    val colorsMap = colors.map { s: String ->
        s.reversed()
    }

    val numbers = listOf(1, 2, 3, 4, 5)
    val quadNumbers = numbers.map { it * it }

    println(quadNumbers)
    println(colorsMap)


    val listInList = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))

    println(listInList.flatten())
//    val filteredColorsSequence = colors.asSequence().filter {
//        println("In Sequence:$it")
//        it.contains("red")
//    }
//
//    val filteredColorsList = colors.filter {
//        println("In List:$it")
//        it.contains("red")
//    }
//
////    println(filteredColorsSequence)
////    println(filteredColorsList)
//    val filteredColorsSequence2 = filteredColorsSequence.filter { it.length > 5 }
//
//    println(filteredColorsSequence2)
//    println(filteredColorsSequence2.toList())
}