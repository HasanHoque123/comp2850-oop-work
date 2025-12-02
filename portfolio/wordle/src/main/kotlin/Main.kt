fun main() {


    //read all the words from file 
    val words = readWordList("/workspaces/comp2850-oop-work/portfolio/wordle/data/words.txt")

    //pick a random word that will be guessed
    val chosenWord = pickRandomWord(words)
   

    println("guess a 5 letter word. You have 10 attempts")

    var attempts = 1//number of guesses 
    while (attempts <= 10) {//user has a maximum of 10 guesses 
        val guess = obtainGuess(attempts)// ask for a guess. will keep guessing until a valid guess is given
        val matches = evaluateGuess(guess, chosenWord)//guess is compared with the word. will be stored in this variable

        displayGuess(guess, matches)//print matching/not matching letters 

        //check if all the characters match the chosen word 
        if (0 !in matches){
            println("you guessed in $attempts goes")
            return
        }

        attempts ++//increment attempts if they havent guessed correctly 

    }

    println("out of attempts")

}
