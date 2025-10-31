import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldNotContain

import java.io.File

@Suppress("unused")
class WordleTest : StringSpec({
    // Write your tests here

    "picks a random word from a list and returns it" {
        val words = mutableListOf("hasan", "nasah", "hoque")
        val randWord = pickRandomWord(words)
        
        
        withClue("returned word should be from original list") {
            listOf("hasan", "nasah", "hoque").contains(randWord) shouldBe true
         }
         
         withClue("Returned word should be removed from list") {
            words shouldNotContain randWord
          }
    }

    "list with only one element" {
        val words = mutableListOf("hasan")
        val randWord = pickRandomWord(words)

        randWord shouldBe "hasan"
        words.size shouldBe 0
    }    
    
    
    "returns true if given word 5 letters" {
        withClue("word = hasan") {isValid("hasan") shouldBe true}
        withClue("word = neroo") {isValid("neroo") shouldBe true}
        withClue("word = itcan") {isValid("itcan") shouldBe true}
    }


    "returns false if word is shorter than 5 letters" {
        withClue("word = cat") {isValid("cat") shouldBe false}
        withClue("word = hi") {isValid("hi") shouldBe false}
        withClue("word = n") {isValid("n") shouldBe false}
    }

    "returns false if word is longer than 5 letters" {
        withClue("word = edward") {isValid("edward") shouldBe false}
        withClue("word = eduardo") {isValid("eduardo") shouldBe false}
        withClue("word = superman") {isValid("superman") shouldBe false}
    }


    "returns correct list when valid word list file is given" {
        
        val tempFile = File.createTempFile("wordlist", ".txt")
        tempFile.writeText(
            """
            apple
            brain
            chair
            doubt
            eager
            """.trimIndent()
        )

        val result = readWordList(tempFile.absolutePath)

        withClue("the function should return all lines as a mutable list") {
            result shouldBe mutableListOf("apple", "brain", "chair", "doubt", "eager")
        }

        
        tempFile.deleteOnExit()
    }

    "error when file does not exist" {
        val invalidPath = "error_file.txt"
        val exception = kotlin.runCatching {

        }
    }


 

})
