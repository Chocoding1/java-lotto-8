package lotto.model;

public enum WinningGrade {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(2, 0),
    ;

    private final int matchCount;
    private final int prize;

    WinningGrade(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningGrade of(int equalCount, boolean bonus) {
        if (equalCount == 5 && bonus) {
            return SECOND;
        }

        for (WinningGrade winningGrade : values()) {
            if (winningGrade.matchCount == equalCount) {
                return winningGrade;
            }
        }
        return NONE;
    }
}
