package jtech.fourthTask;

public class SolutionFinder {

    private static SolutionFinder INSTANCE;

    private String answer;

    private SolutionFinder() {
        this.answer = "you search for it on stackoverflow";
    }

    public static SolutionFinder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SolutionFinder();
        }
        return INSTANCE;
    }

    public String getAnswer() {
        return answer;
    }
}
