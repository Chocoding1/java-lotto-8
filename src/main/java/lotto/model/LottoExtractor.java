package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoExtractor {

    private static LottoExtractor instance;

    private LottoExtractor() {
    }

    public static LottoExtractor getInstance() {
        if (instance == null) {
            instance = new LottoExtractor();
        }
        return instance;
    }

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    // 정적 메소드 알아봐
    public List<Integer> getLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
}
