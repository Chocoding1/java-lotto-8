package lotto.util;

import static lotto.model.constant.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.model.constant.LottoConstant.MAX_NUMBER;
import static lotto.model.constant.LottoConstant.MIN_NUMBER;

public class LottoNumberUtil {

    public static void validateNumber(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }
}
