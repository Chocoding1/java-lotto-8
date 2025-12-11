package lotto.model;

public final class ErrorMessage {

    public static final String ERROR_BONUS_NOT_INTEGER = "[ERROR] 보너스 번호는 정수 형태여야 합니다. 현재 보너스 번호: ";
    public static final String ERROR_BONUS_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    public static final String ERROR_BONUS_DUPLICATE_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static final String ERROR_PRICE_NOT_INTEGER = "[ERROR] 구입 금액은 정수 형태여야 합니다.";
    public static final String ERROR_PRICE_AMOUNT = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    public static final String ERROR_PRICE_UNITS = "[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.";

    public static final String ERROR_WINNING_NUMBER_NOT_INTEGER = "[ERROR] 입력한 당첨 번호 내에 쉼표 외의 문자가 존재합니다.";
    public static final String ERROR_WINNING_NUMBER_INVALID_COUNT = "[ERROR] 당첨 번호의 개수는 6개여야 합니다. 현재 개수: ";
    public static final String ERROR_WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    public static final String ERROR_WINNING_NUMBER_DUPLICATE = "[ERROR] 입력한 당첨 번호 내에 중복된 숫자가 존재합니다.";

    private ErrorMessage() {
    }
}
