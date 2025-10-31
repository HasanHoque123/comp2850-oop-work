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
    return words[randomWordIndex]

}

fun obtainGuess(attempt: Int): String {
    while(true) {
        println("attempt: $attempt")
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
    for(n in 0..4){
        if (guess[n] == target[n]) {
            comparisons[n] == 1
        } else{
            comparisons[n] == 0
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