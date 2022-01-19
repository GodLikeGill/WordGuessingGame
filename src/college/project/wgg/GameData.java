package college.project.wgg;

public class GameData {

    private int score;
    private int levelNumber;
    private int chancesRemaining;
    private String secretWord;
    private String currentWord;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getChancesRemaining() {
        return chancesRemaining;
    }

    public void setChancesRemaining(int chancesRemaining) {
        this.chancesRemaining = chancesRemaining;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }
}
