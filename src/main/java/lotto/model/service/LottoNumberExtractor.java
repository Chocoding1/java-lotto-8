package lotto.model.service;

import static lotto.model.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.model.constant.LottoConstant.MAX_NUMBER;
import static lotto.model.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberExtractor {

    public List<Integer> extractNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_LENGTH);
    }
}
