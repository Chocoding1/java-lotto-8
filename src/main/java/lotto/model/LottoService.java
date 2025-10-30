package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private static LottoService instance;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }
        return instance;
    }

    public List<Lotto> publishLotto(int purchasePrice) {
        int lottoQuantity = getLottoQuantity(purchasePrice);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private int getLottoQuantity(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }
}
