package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumberGenerator;

public class LottoPublisher {

    public static PublishedLotto publish(PurchasePrice purchasePrice) {
        int publishCount = purchasePrice.lottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < publishCount; i++) {
            Lotto lotto = publishLotto();
            lottos.add(lotto);
        }
        return new PublishedLotto(lottos);
    }

    private static Lotto publishLotto() {
        List<Integer> numbers = LottoNumberGenerator.generateNumbers();
        return new Lotto(numbers);
    }
}
