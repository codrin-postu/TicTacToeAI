package tictactoe;

public enum Difficulty {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    ;

    private String diff;

    Difficulty(String diff) {
        this.diff = diff;
    }

    public String getDifficulty() {
        return diff;
    }
}
