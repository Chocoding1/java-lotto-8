package lotto.model.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.model.domain.PublishedLotto;
import lotto.model.domain.PurchasePrice;

public class LottoPublisher {

    private final LottoNumberExtractor lottoNumberExtractor;

    public LottoPublisher(LottoNumberExtractor lottoNumberExtractor) {
        this.lottoNumberExtractor = lottoNumberExtractor;
    }

    public PublishedLotto publishLotto(PurchasePrice purchasePrice) {
        int quantity = purchasePrice.getLottoQuantity();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(getLotto());
        }
        return new PublishedLotto(lottos);
    }

    private Lotto getLotto() {
        return new Lotto(lottoNumberExtractor.extractNumbers());
    }
}
