package lotto.model;

public class CompareResult {

    private final int matchCount;
    private final boolean bonusMatch;

    public CompareResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
