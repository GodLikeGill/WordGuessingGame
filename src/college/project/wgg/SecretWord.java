package college.project.wgg;

public class SecretWord {

    private String actualWord = "";
    private String currentWord = "";

    public SecretWord(GameData gameData){
        actualWord = gameData.getSecretWord();
        currentWord = gameData.getCurrentWord();
    }

    public boolean containsLetter(String letter){
        if(actualWord.contains(letter)){
            if(currentWord.charAt(actualWord.indexOf(letter)) == '_'){
                System.out.println("CORRECT: " + letter + " is in the word!");
                return true;
            }
            System.out.println("WRONG: You  have already Guessed that letter.");
            return false;
        }
        System.out.println("WRONG: " + letter + " is not in the word!");
        return false;
    }

    public boolean hasLettersRemaining(){
        return !currentWord.contains("_");
    }

    public String toString(){
        return currentWord;
    }
}
