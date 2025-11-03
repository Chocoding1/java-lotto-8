package lotto.model.service;

import static lotto.model.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.model.constant.LottoConstant.MAX_NUMBER;
import static lotto.model.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.PublishedLotto;
import lotto.model.domain.PurchasePrice;

public class LottoPublisher {

    // 정적 메소드 알아봐
    public PublishedLotto publishLotto(PurchasePrice purchasePrice) {
        int quantity = purchasePrice.getLottoQuantity();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(getLotto());
        }
        return new PublishedLotto(lottos);
    }

    private static Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_LENGTH));
    }
}
