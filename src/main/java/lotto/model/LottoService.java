package lotto.model;

import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private static LottoService instance;

    private final LottoComparator lottoComparator = LottoComparator.getInstance();

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }
        return instance;
    }

    public List<CompareResult> compareLottoNumbers(PublishedLotto publishedLotto, WinningLotto winningLotto) {
        return publishedLotto.getLottos().stream()
                .map(lotto -> lottoComparator.compareLotto(lotto, winningLotto))
                .toList();
    }
}
