package lotto.model;

public enum WinningGrade {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치"),
    NONE(2, 0, ""),
    ;

    private final int matchCount;
    private final int prize;
    private final String printFormat;

    WinningGrade(int matchCount, int prize, String printFormat) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.printFormat = printFormat;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrintFormat() {
        return printFormat;
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
