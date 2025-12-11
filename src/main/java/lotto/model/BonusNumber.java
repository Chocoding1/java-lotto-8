package lotto.model;

import static lotto.model.ErrorMessage.*;
import static lotto.model.LottoConstants.*;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_6939783949188191bf95ef52e12ad93d
 */
public class BonusNumber {

    private final int number;

    public BonusNumber(String initialNumber) {
        int number = convertToInt(initialNumber);
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void validateDuplicate(WinningNumber winningNumber) {
        if (winningNumber.isContain(number)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE_NUMBER);
        }
    }

    public boolean isMatch(Lotto lotto) {
        return lotto.isMatch(number);
    }

    private int convertToInt(String initialBonusNumber) {
        try {
            return Integer.parseInt(initialBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_BONUS_NOT_INTEGER + initialBonusNumber);
        }
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException(ERROR_BONUS_OUT_OF_RANGE);
        }
    }
}
