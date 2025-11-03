package lotto.model.service;

import java.util.List;
import lotto.model.domain.LottoRank;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.PublishedLotto;
import lotto.model.domain.lotto.WinningLotto;

public class LottoComparator {

    public List<LottoRank> getCompareResults(PublishedLotto publishedLotto, WinningLotto winningLotto) {
        return publishedLotto.getLottos().stream()
                .map(lotto -> getLottoRank(lotto, winningLotto))
                .toList();
    }

    private LottoRank getLottoRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.getMatchCount(winningLotto);
        boolean bonusMatch = lotto.isContain(winningLotto.getBonusNumber());

        return LottoRank.getRank(matchCount, bonusMatch);
    }
}
