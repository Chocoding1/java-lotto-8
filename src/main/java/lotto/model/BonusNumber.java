package lotto.model;

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

    private int convertToInt(String initialBonusNumber) {
        try {
            return Integer.parseInt(initialBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수 형태여야 합니다. 현재 보너스 번호: " + initialBonusNumber);
        }
    }

    private void validateRange(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}
