fun main() {
    val house: House = House(color = "White")
    val house1 = House(color = "Green")
    val house2 = House(city = "Brussel")

//    house.updateColor("Blue")
//    println(house.color)

//    house1.color = "Yellow"
//    println(house1.color)

    // Werkt niet!
    // house1.numberOfWindows = 10

    val person = Person("Matthias", "Druwé")
    println(person.fullname)

    person.fullname = "Tom Knapen"

    println(person.firstname)
    println(person.lastname)
}

class House(var color: String, val numberOfWindows: Int = 5, val forSale: Boolean = false) {

    constructor(city: String) : this(color = "white") {
        println(city)
    }

    init {
        println("Huis is gemaakt")
    }

    init {
        println("Huis -  kleur: $color, aantal ramen : $numberOfWindows, te koop: $forSale")
    }


    fun updateColor(newColor: String) {
        color = newColor
    }
}


class Person(var firstname: String, var lastname: String) {
    var fullname: String
        get() = "$firstname $lastname"
        set(value) {
            val splitName = value.split(" ")
            firstname = splitName[0]
            lastname = splitName[1]
        }
}