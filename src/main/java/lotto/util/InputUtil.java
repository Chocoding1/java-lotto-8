package lotto.util;

public final class InputUtil {

    private InputUtil() {
    }

    public static int convertToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수 형태의 숫자여야 합니다.");
        }
    }
}
