package college.project.wgg;

public class PreviousGameResult {

    private int score;
    private String time;

    public PreviousGameResult(int score, String time) {
        this.score = score;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Score: " + score + "\nTime: " + time + "\n";
    }
}
