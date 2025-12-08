package lotto.model;

public class BonusNumber {

    private final int number;

    public BonusNumber(String initialNumber) {
        this.number = convertToInt(initialNumber);
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
}
