package lotto.model;

public class LottoComparator {

    private static LottoComparator instance;

    private LottoComparator() {
    }

    public static LottoComparator getInstance() {
        if (instance == null) {
            instance = new LottoComparator();
        }
        return instance;
    }

    public CompareResult compareLotto(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.getMatchCount(winningLotto.getLotto());
        boolean bonusMatch = false;

        if (lotto.isContain(winningLotto.getBonusNumber())) {
            matchCount++;
            bonusMatch = true;
        }

        return new CompareResult(matchCount, bonusMatch);
    }
}
