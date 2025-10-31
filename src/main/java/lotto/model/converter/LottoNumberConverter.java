package lotto.model.converter;

public class LottoNumberConverter {

    public static int convertToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수 형태의 숫자여야 합니다.");
        }
    }
}
