// Implement the six required functions here
import java.io.File 
import kotlin.random.Random 



fun isValid(word: String): Boolean {
    if(word.length == 5) {
        return true
    } else {
        return false 
    }
}

fun readWordList(filename: String): MutableList<String> {
    return File(filename).readLines().toMutableList()

}


fun pickRandomWord(words: MutableList<String>): String {
    val randomWordIndex = Random.nextInt(words.size)
    return words.removeAt(randomWordIndex)
}

fun obtainGuess(attempt: Int): String {
    println("attempt: $attempt")
    while(true) {
        val userInput = readln()
        if (isValid(userInput)) {
            return userInput
        } else {
            println("word is invalid try again")
        }
    } 
}


fun evaluateGuess(guess: String, target: String): List<Int> {
    val comparisons = mutableListOf<Int>()
    val lowerCaseGuess = guess.lowercase()//converting to lowercase for comparison as words in words.txt are all upper case
    val lowerCaseTarget = target.lowercase()//converting to lowercase for comparison as words in words.txt are all upper case
    for (n in 0..4) {
        if (lowerCaseGuess[n] == lowerCaseTarget[n]) {
            comparisons.add(1)
        } else {
            comparisons.add(0)
        }
    }
    return comparisons
}



fun displayGuess(guess: String, matches: List<Int>) {
    for (n in 0..4){
        if (matches[n] == 1) {
            print(guess[n])
        } else{
            println("?")
        }
    }
}