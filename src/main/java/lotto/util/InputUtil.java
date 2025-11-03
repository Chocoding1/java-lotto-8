package lotto.util;

import static lotto.model.constant.ErrorMessage.INPUT_VALUE_NOT_INTEGER;

public final class InputUtil {

    private static final String DELIMITER = ",";

    private InputUtil() {
    }

    public static int convertToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_NOT_INTEGER);
        }
    }

    public static String[] splitInitialNumbers(String initialNumbers) {
        return initialNumbers.split(DELIMITER);
    }
}
