package college.project.wgg;

import java.util.Locale;
import java.util.Scanner;

public class Level {

    GameData gameData;
    SecretWord secretWord;
    boolean debugOn = false;

    public Level(GameData gameData) {
        this.gameData = gameData;
    }

    //Updates the state of secretWord
    public boolean updateGuess(String guessedLetter){
        secretWord = new SecretWord(gameData);
        if(secretWord.containsLetter(guessedLetter)) {
            char[] charArray = gameData.getCurrentWord().toCharArray();
            for(int i = 0; i < gameData.getSecretWord().length(); i++)
                if(gameData.getSecretWord().charAt(i) == guessedLetter.charAt(0))
                    charArray[i] = guessedLetter.charAt(0);
            gameData.setCurrentWord(String.valueOf(charArray));
            return true;
        }
        return false;
    }

    //Returns if the player has guessed the word
    public boolean isWordGuessed(){
        secretWord = new SecretWord(gameData);
        return secretWord.hasLettersRemaining();
    }

    public void randomWordGenerator(){
        gameData.setSecretWord("TORONTO");
        gameData.setCurrentWord(gameData.getSecretWord().replaceAll("[a-zA-Z]", "_"));
    }

    //Takes user inputs and processes what should happen if words is guessed or not
    public void gameProcess(){
        System.out.println(this);
        System.out.println("Guess a Letter: ");
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        System.out.println("You guessed : " + input);
        if(updateGuess(String.valueOf(input).toUpperCase())){
            if(isWordGuessed()){
                nextLevel();
                if(gameData.getLevelNumber() >= 4){
                    System.out.println(
                            "================================================================" + "\n" +
                            "Congratulations, You finished the game by completing all levels!" + "\n" +
                            "Your Score is: " + gameData.getScore() + "\n" +
                            "================================================================");
                    return;
                }
            }
            gameProcess();
        }else{
            gameData.setChancesRemaining(gameData.getChancesRemaining() - 1);
            if(gameData.getChancesRemaining() < 1){
                System.out.println("\nGame Over, since you lost all your chances remaining! Thank you for playing.");
                return;
            }
            gameProcess();
        }
    }

    //Update values if the player moves up a level
    public void nextLevel(){
        gameData.setLevelNumber(gameData.getLevelNumber() + 1);
        gameData.setScore(gameData.getScore() + gameData.getChancesRemaining());
        System.out.println("You Guessed the Secret word " + gameData.getSecretWord() + ".\n\n");
        if(!(gameData.getLevelNumber() >= 4)) {
            randomWordGenerator();
            gameData.setChancesRemaining(7);
            System.out.println("====[ Welcome to Level " + gameData.getLevelNumber() + " ]====" + "\n\tCurrent Score: " + gameData.getScore());
        }
    }

    public String toString(){
        if(debugOn) return "\nCurrent Level: " + gameData.getLevelNumber() + "\nChances Remaining: " + gameData.getChancesRemaining() + "\nSecret Word: " + gameData.getCurrentWord() + "\nActual Word: " + gameData.getSecretWord() + "\n";
        return "\nCurrent Level: " + gameData.getLevelNumber() + "\nChances Remaining: " + gameData.getChancesRemaining() + "\nSecret Word: " + gameData.getCurrentWord() + "\n";
    }
}
