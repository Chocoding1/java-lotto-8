package lotto.model;

import static lotto.model.LottoConstant.MAX_NUMBER;
import static lotto.model.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    private static final int NUMBER_COUNT = 6;

    private static LottoPublisher instance;

    private LottoPublisher() {
    }

    public static LottoPublisher getInstance() {
        if (instance == null) {
            instance = new LottoPublisher();
        }
        return instance;
    }

    // 정적 메소드 알아봐
    public PublishedLotto getLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(getLotto());
        }
        return new PublishedLotto(lottos);
    }

    private static Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
    }
}
