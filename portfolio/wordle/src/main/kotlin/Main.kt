fun main() {

    println("Starting program...")

    //read all the words from file 
    val words = readWordList("/workspaces/comp2850-oop-work/portfolio/wordle/data/words.txt")

    //pick a random word that will be guessed
    val chosenWord = pickRandomWord(words)
     println("Chosen word: $chosenWord")

    println("guess a 5 letter word. You have 10 attempts")

    var attempts = 1
    while (attempts <= 10) {
        val guess = obtainGuess(attempts)
        val matches = evaluateGuess(guess, chosenWord)

        displayGuess(guess, matches)

        //check if all the characters match the chosen word 
        if (matches.all  {it ==1}) {
            println("you guessed in $attempts goes")
            return
        }

        attempts ++

    }

    println("out of attempts")

}
