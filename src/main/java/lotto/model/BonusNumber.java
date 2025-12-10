package lotto.model;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_6939783949188191bf95ef52e12ad93d
 */
public class BonusNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String ERROR_NOT_INTEGER = "[ERROR] 보너스 번호는 정수 형태여야 합니다. 현재 보너스 번호: ";
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";

    private final int number;

    public BonusNumber(String initialNumber) {
        int number = convertToInt(initialNumber);
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int convertToInt(String initialBonusNumber) {
        try {
            return Integer.parseInt(initialBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER + initialBonusNumber);
        }
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }
}
