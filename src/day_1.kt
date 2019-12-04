import java.io.File
import kotlin.math.floor

fun main() {
    var numbers: ArrayList<Double> = ArrayList()
    File("./resources/day_1_input.txt").forEachLine { numbers.add(it.toDouble()) }

    var sum: Int = 0
    numbers.forEach {
        sum += calculateRequiredFuel(it)
    }
    println(sum)
}

// part 1
//fun calculateFuelRequired(mass: Double): Int {
//    return (Math.floor(mass / 3) - 2).toInt()
//}

// part 2
fun calculateRequiredFuel(mass: Double): Int {
    var fuelRequired: Int = (floor(mass / 3) - 2).toInt()
    if (fuelRequired <= 0) {
        return 0
    } else {
        return fuelRequired + calculateRequiredFuel(fuelRequired.toDouble())
    }
}

