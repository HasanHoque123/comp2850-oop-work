// Implement the six required functions here
import java.io.File 
import kotlin.random.Random 



fun isValid(word: String): Boolean {
    if(word.length == 5) {//check if the length of the word is 5 characters
        return true//if it is 5 characters then return true
    } else {
        return false //if its false then return false 
    }
}

fun readWordList(filename: String): MutableList<String> {
    return File(filename).readLines().toMutableList() // File(Filename) creates a file object referencing that specific path 
    //readlines reads the file and returns a list containing all the elements. 

}


fun pickRandomWord(words: MutableList<String>): String {
    val randomWordIndex = Random.nextInt(words.size)
    return words.removeAt(randomWordIndex)
}

fun obtainGuess(attempt: Int): String {
    println("attempt: $attempt") //print current attempt number 
    while(true) { //while the user input is not valid 
        val userInput = readln()//reads the input from stdin
        if (isValid(userInput)) { //calling the isvalid function to check if the user input is valid 
            return userInput
        } else {
            println("word is invalid try again")    
        }
    } 
}


fun evaluateGuess(guess: String, target: String): List<Int> {
    val comparisons = mutableListOf<Int>() //a list to store the results of the comparisons. this will be 1s and 0s so it needs to be int
    val lowerCaseGuess = guess.lowercase()//converting to lowercase for comparison as words in words.txt are all upper case
    val lowerCaseTarget = target.lowercase()//converting to lowercase for comparison as words in words.txt are all upper case
    for (n in 0..4) { //loop through all 5 characters
        if (lowerCaseGuess[n] == lowerCaseTarget[n]) {//if the characters match then 
            comparisons.add(1)//add 1 to the list in that index 
        } else {
            comparisons.add(0) //add 0 
        }
    }
    return comparisons
}



fun displayGuess(guess: String, matches: List<Int>) {
    for (n in 0..4){//loop through the 5 characters 
        if (matches[n] == 1) {
            print(guess[n])//print the correct letters
        } else{
            println("?")//for positions that dont match 
        }
    }
}