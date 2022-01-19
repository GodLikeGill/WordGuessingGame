package college.project.wgg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GameData gameData = new GameData();
        Level level = new Level(gameData);

        gameData.setSecretWord("LONDON");
        gameData.setCurrentWord("______");

        onStartup(gameData,level);
    }

    public static void onStartup(GameData gameData, Level level){

        System.out.println(
                "=================[ Word Guessing Game ]=================" + "\n\t" +
                        "Please select an option: " + "\n\t" +
                        "1. Play Game" + "\n\t" +
                        "2. Results of Previous Games" + "\n\t" +
                        "3. Exit the Game" + "\n");


        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> onPlay(gameData, level);
            case 2 -> onPreviousGames();
            case 3 -> onExit();
            default -> {
                System.out.println("Please re-enter a valid option(1-3).");
                onStartup(gameData, level);
            }
        }
    }

    public static void onPlay(GameData gameData, Level level){
        gameData.setLevelNumber(1);
        gameData.setChancesRemaining(7);
        System.out.println("====[ Welcome to Level " + gameData.getLevelNumber() + " ]====" + "\n\tCurrent Score: " + gameData.getScore());
        level.gameProcess();
    }

    public static void onPreviousGames(){

    }

    public static void onExit(){
        System.out.println("====[ Thank you for playing. GoodBye! ]====");
    }
}
