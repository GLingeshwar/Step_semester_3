class Scorecard {
    private boolean[] results;
    private int questionCount;
    private int answersRecorded;

    public Scorecard(int questionCount) {
        this.questionCount = questionCount;
        results = new boolean[questionCount];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answersRecorded < questionCount) {
            results[answersRecorded] = correct;
            answersRecorded++;
        } else {
            System.out.println("All questions have been answered");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final score: " + sc.getScore());
    }
}
