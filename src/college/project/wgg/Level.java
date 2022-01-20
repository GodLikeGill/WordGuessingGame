package college.project.wgg;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Level {

    private int score;
    private int levelNumber;
    private int chancesRemaining;
    boolean debugOn = true;

    SecretWord secretWord;

    public Level(SecretWord secretWord) {
        this.secretWord = secretWord;
    }

    //Updates the state of secretWord
    public boolean updateGuess(String guessedLetter){
        if(secretWord.containsLetter(guessedLetter)) {
            char[] charArray = secretWord.getCurrentWord().toCharArray();
            for(int i = 0; i < secretWord.getActualWord().length(); i++)
                if(secretWord.getActualWord().charAt(i) == guessedLetter.charAt(0))
                    charArray[i] = guessedLetter.charAt(0);
            secretWord.setCurrentWord(String.valueOf(charArray));
            return true;
        }
        return false;
    }

    //Returns if the player has guessed the word
    public boolean isWordGuessed(){
        return secretWord.hasLettersRemaining();
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
                if(levelNumber >= 4){

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime timeNow = LocalDateTime.now();

                    System.out.println(
                            "================================================================" + "\n" +
                            "Congratulations, You finished the game by completing all levels!" + "\n" +
                            "Your Score is: " + score + "\n" +
                            "Day and Time is: " + dtf.format(timeNow) + "\n" +
                            "================================================================" + "\n");
                    Main.storeGameData(score, dtf.format(timeNow));
                    Main.onStartup(this);
                    return;
                }
            }
            gameProcess();
        }else{
            chancesRemaining--;
            if(chancesRemaining < 1){
                System.out.println("\nGame Over, since you lost all your chances remaining! Thank you for playing.\n\n");
                Main.onStartup(this);
                return;
            }
            gameProcess();
        }
    }

    //Update values if the player moves up a level
    public void nextLevel(){
        levelNumber += 1;
        score += chancesRemaining;
        System.out.println("You Guessed the Secret word " + secretWord.getActualWord() + ".\n\n");
        if(levelNumber < 4) {
            chancesRemaining = 7;
            secretWord.randomWordGenerator();
            System.out.println("========[ Welcome to Level " + levelNumber + " ]========" + "\n\tCurrent Score: " + score);
        }
    }

    public void onPlay(){
        score = 0;
        levelNumber = 1;
        chancesRemaining = 7;
        secretWord.randomWordGenerator();
        System.out.println("========[ Welcome to Level " + levelNumber + " ]========" + "\n\tCurrent Score: " + score);
        gameProcess();
    }

    public String toString(){
        if(debugOn) return "\nCurrent Level: " + levelNumber + "\nChances Remaining: " + chancesRemaining + "\nSecret Word: " + secretWord + "\nActual Word: " + secretWord.getActualWord() + "\n";
        return "\nCurrent Level: " + levelNumber + "\nChances Remaining: " + chancesRemaining + "\nSecret Word: " + secretWord + "\n";
    }
}
