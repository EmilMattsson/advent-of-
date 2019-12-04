import java.io.File

fun main() {
    val dayTwoInput: List<String> = File("c:/dev/java/advent_of_code/resources/day_2_input.txt").readLines()
    val integerList: MutableList<Int> = dayTwoInput[0]
        .split(',')
        .map { it.toInt() }
        .toMutableList()

    println(calculateOpcodes(integerList))
}

fun calculateOpcodes(intList: MutableList<Int>): List<Int> {
    var firstIntegerPosition = 0
    var secondIntegerPosition = 1
    var thirdIntegerPosition = 2
    var fourthIntegerPosition = 3
    val indexStep = 4

    var firstOpcodeInteger = intList[firstIntegerPosition]
    var secondOpcodeInteger = intList[secondIntegerPosition]
    var thirdOpcodeInteger = intList[thirdIntegerPosition]
    var opcodeResultIndex = intList[fourthIntegerPosition]

    println(secondOpcodeInteger)

    do {
        var opcodeResult = calculateOpcode(firstOpcodeInteger, secondOpcodeInteger, thirdOpcodeInteger, intList)
        intList[opcodeResultIndex] = opcodeResult

        firstIntegerPosition += firstIntegerPosition + indexStep
        secondIntegerPosition += secondIntegerPosition + indexStep
        thirdIntegerPosition += thirdIntegerPosition + indexStep
        fourthIntegerPosition += opcodeResultIndex + indexStep

        firstOpcodeInteger = intList[firstIntegerPosition]
        secondOpcodeInteger = intList[secondIntegerPosition]
        thirdOpcodeInteger = intList[thirdIntegerPosition]
        opcodeResultIndex = intList[fourthIntegerPosition]

    } while (firstOpcodeInteger != 99 || fourthIntegerPosition <= intList.size)

    return intList
}

fun calculateOpcode(operation: Int, firstNumber: Int, secondNumber: Int, integerList: List<Int>): Int {
    var result = 0
    when (operation) {
        1 -> result = integerList[firstNumber] + integerList[secondNumber]
        2 -> result = integerList[firstNumber] * integerList[secondNumber]
//        99 -> result = 99
    }
    return result
}