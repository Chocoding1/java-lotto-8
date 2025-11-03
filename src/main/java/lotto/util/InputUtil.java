package lotto.util;

import static lotto.exception.ErrorMessage.INPUT_VALUE_NOT_INTEGER;

public final class InputUtils {

    private InputUtils() {
    }

    public static int convertToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_NOT_INTEGER);
        }
    }
}
