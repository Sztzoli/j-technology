package jtech.fourthTask;

public class SolutionFinder {

    private static SolutionFinder instance = null;

    public String answer;

    private SolutionFinder() {
        this.answer = "you search for it on stackoverflow";
    }

    public static SolutionFinder getInstance() {
        if (instance == null) {
            instance = new SolutionFinder();
        }
        return instance;
    }
}
