package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private static LottoService instance;

    private final LottoExtractor lottoExtractor = LottoExtractor.getInstance();
    private final LottoComparator lottoComparator = LottoComparator.getInstance();

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }
        return instance;
    }

    public List<Lotto> publishLotto(int purchasePrice) {
        int lottoQuantity = getLottoQuantity(purchasePrice); // 로또 발행 개수는 service에서 하고, 로또 추출기는 입력받은 횟수만큼 로또 추출만 하도록

        return lottoExtractor.getLotto(lottoQuantity);
    }

    private int getLottoQuantity(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<CompareResult> compareLottoNumbers(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<CompareResult> compareResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            compareResults.add(lottoComparator.compareLotto(lotto, winningLotto, bonusNumber));
        }

        return compareResults;
    }
}
