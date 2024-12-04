package z4;

public class Athlete {
    private String surname;
    private String name;
    private int totalScore;

    public Athlete(String surname, String name, int totalScore) {
        this.surname = surname;
        this.name = name;
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + totalScore;
    }
}
