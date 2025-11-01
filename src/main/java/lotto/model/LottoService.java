package lotto.model;

import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private static LottoService instance;

    private final LottoPublisher lottoPublisher = LottoPublisher.getInstance();
    private final LottoComparator lottoComparator = LottoComparator.getInstance();

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }
        return instance;
    }

    public PublishedLotto publishLotto(PurchasePrice purchasePrice) {
        int lottoQuantity = purchasePrice.getLottoQuantity();

        return lottoPublisher.getLotto(lottoQuantity);
    }


    public List<CompareResult> compareLottoNumbers(PublishedLotto publishedLotto, WinningLotto winningLotto) {
        List<CompareResult> compareResults = publishedLotto.getLottos().stream()
                .map(lotto -> lottoComparator.compareLotto(lotto, winningLotto))
                .toList();

        return compareResults;
    }
}
