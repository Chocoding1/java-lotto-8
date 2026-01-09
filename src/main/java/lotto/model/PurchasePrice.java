package lotto.model;

public class PurchasePrice {

    private static final int LOTTO_PRICE_UNITS = 1000;

    private final int price;

    public PurchasePrice(String input) {
        int price = convertToInt(input);
        validatePrice(price);
        this.price = price;
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수 형태로 입력해 주세요.");
        }
    }

    private void validatePrice(int price) {
        if (price % LOTTO_PRICE_UNITS != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해 주세요.");
        }
    }
}
