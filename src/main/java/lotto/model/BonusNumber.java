package lotto.model;

public class BonusNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public BonusNumber(String input) {
        int number = convertToInt(input);
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isContainIn(Lotto publishedLotto) {
        return publishedLotto.isContain(number);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수 형태여야 합니다.");
        }
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}
