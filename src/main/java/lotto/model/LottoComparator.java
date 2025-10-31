package lotto.model;

import lotto.model.converter.LottoConverter;

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

    public CompareResult compareLotto(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = lotto.compare(winningLotto);
        boolean bonusMatch = false;
        if (lotto.isContain(bonusNumber)) {
            matchCount++;
            bonusMatch = true;
        }

        return new CompareResult(matchCount, bonusMatch);
    }
}
