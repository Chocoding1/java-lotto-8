package lotto.model;

import lotto.view.InputView;

public class LottoNumber {

    private final int number;

    public LottoNumber(String inputValue) {
        int number = convertToInt(inputValue);
        validateNumber(number);
        this.number = number;
    }

    private int convertToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수 형태의 숫자여야 합니다.");
        }
    }

    private void validateNumber(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}
