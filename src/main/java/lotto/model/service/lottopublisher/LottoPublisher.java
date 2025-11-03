package lotto.model.service.lottopublisher;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.PublishedLotto;
import lotto.model.domain.PurchasePrice;

public class LottoPublisher {

    private final LottoNumberExtractor lottoNumberExtractor;

    public LottoPublisher(LottoNumberExtractor lottoNumberExtractor) {
        this.lottoNumberExtractor = lottoNumberExtractor;
    }

    public PublishedLotto publishLotto(PurchasePrice purchasePrice) {
        int quantity = purchasePrice.getLottoQuantity();

        List<Lotto> lottos = IntStream.range(0, quantity)
                .mapToObj(i -> createLotto())
                .toList();

        return new PublishedLotto(lottos);
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumberExtractor.extractNumbers());
    }
}
