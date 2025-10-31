package lotto.model.validator;

import static lotto.model.LottoConstant.MAX_NUMBER;
import static lotto.model.LottoConstant.MIN_NUMBER;

public class LottoNumberValidator {

    public static void validateNumber(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}
