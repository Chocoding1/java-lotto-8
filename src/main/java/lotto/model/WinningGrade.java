package lotto.model;

public enum WinningGrade {

    FIRST(6, false, 2_000_000_000),
    SECOND(6, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ;

    private final int matchCount;
    private final boolean isBonus;
    private final int prize;

    WinningGrade(int matchCount, boolean isBonus, int prize) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getPrize() {
        return prize;
    }
}
