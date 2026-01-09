package lotto.model;

import java.util.List;

public class LottoComparator {

    private final PublishedLotto publishedLotto;
    private final WinningLotto winningLotto;

    public LottoComparator(PublishedLotto publishedLotto, WinningLotto winningLotto) {
        this.publishedLotto = publishedLotto;
        this.winningLotto = winningLotto;
    }

    public WinningResult compare() {
        List<WinningGrade> compareResult = publishedLotto.compare(winningLotto);
        return new WinningResult(compareResult);
    }
}
