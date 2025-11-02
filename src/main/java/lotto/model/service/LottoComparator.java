package lotto.model.service;

import java.util.List;
import lotto.model.domain.CompareResult;
import lotto.model.domain.Lotto;
import lotto.model.domain.PublishedLotto;
import lotto.model.domain.WinningLotto;

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

    public List<CompareResult> getCompareResults(PublishedLotto publishedLotto, WinningLotto winningLotto) {
        return publishedLotto.getLottos().stream()
                .map(lotto -> getCompareResult(lotto, winningLotto))
                .toList();
    }

    private CompareResult getCompareResult(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.getMatchCount(winningLotto.getLotto());
        boolean bonusMatch = false;

        if (lotto.isContain(winningLotto.getBonusNumber())) {
            matchCount++;
            bonusMatch = true;
        }

        return new CompareResult(matchCount, bonusMatch);
    }
}
