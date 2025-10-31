package lotto.model;

import static lotto.model.LottoConstant.MAX_NUMBER;
import static lotto.model.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoExtractor {

    private static final int NUMBER_COUNT = 6;

    private static LottoExtractor instance;

    private LottoExtractor() {
    }

    public static LottoExtractor getInstance() {
        if (instance == null) {
            instance = new LottoExtractor();
        }
        return instance;
    }

    // 정적 메소드 알아봐
    public List<Lotto> getLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)));
        }
        return lottos;
    }
}
