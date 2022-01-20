package college.project.wgg;

import java.util.Random;

public class SecretWord {

    private final String[] wordDB = {"TORONTO", "MONTREAL", "CALGARY", "OTTAWA", "EDMONTON", "MISSISSAUGA",  "WINNIPEG", "VANCOUVER", "BRAMPTON", "HAMILTON"};
    private String actualWord;
    private String currentWord;

    public String getActualWord() {
        return actualWord;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public boolean containsLetter(String letter) {
        if (actualWord.contains(letter)) {
            if (currentWord.charAt(actualWord.indexOf(letter)) == '_') {
                System.out.println("CORRECT: " + letter + " is in the word!");
                return true;
            }
            System.out.println("WRONG: You  have already Guessed that letter.");
            return false;
        }
        System.out.println("WRONG: " + letter + " is not in the word!");
        return false;
    }

    public void randomWordGenerator(){
        Random random = new Random();
        int randomNumber = random.nextInt(wordDB.length + 1);
        actualWord = wordDB[randomNumber];
        currentWord = actualWord.replaceAll("[a-zA-Z]", "_");
    }

    public boolean hasLettersRemaining() {
        return !currentWord.contains("_");
    }

    public String toString() {
        return currentWord;
    }
}