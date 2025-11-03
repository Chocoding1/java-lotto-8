package lotto.exception;

public class ErrorMessage {

    public static final String INPUT_VALUE_NOT_INTEGER = "[ERROR] 입력값은 정수 형태의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER_OF_LOTTO = "[ERROR] 당첨 번호와 중복된 번호가 존재합니다.";
    public static final String DUPLICATE_NUMBER_IN_LOTTO = "[ERROR] 로또는 중복된 숫자를 포함하지 않아야 합니다.";
    public static final String INVALID_LOTTO_LENGTH = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    public static final String PRICE_LESS_THAN_LOTTO_PRICE = "[ERROR] 구입금액은 1000원 이상이어야 합니다.";
    public static final String PRICE_NOT_UNITS_OF_LOTTO_PRICE = "[ERROR] 구입금액은 1000원 단위로 입력해주세요.";
}
