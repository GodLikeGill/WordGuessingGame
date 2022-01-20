package college.project.wgg;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<PreviousGameResult> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        SecretWord secretWord = new SecretWord();
        Level level = new Level(secretWord);

        onStartup(level);
    }

    public static void onStartup(Level level){
        System.out.println(
                "=====================[ Word Guessing Game ]=====================" + "\n\t" +
                        "Please select an option: " + "\n\t" +
                        "1. Play Game" + "\n\t" +
                        "2. Results of Previous Games" + "\n\t" +
                        "3. Exit the Game" + "\n");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> level.onPlay();
            case 2 -> onPreviousGames(level);
            case 3 -> System.out.println("\n==============[ Thank you for playing. GoodBye! ]==============");
            default -> {
                System.out.println("Please re-enter a valid option(1-3).");
                onStartup(level);
            }
        }
    }

    public static void storeGameData(int score, String time){
        arrayList.add(new PreviousGameResult(score, time));
    }

    public static void onPreviousGames(Level level){
        for (PreviousGameResult pgr : arrayList ){
            System.out.println(pgr);
        }
        onStartup(level);
    }
}
