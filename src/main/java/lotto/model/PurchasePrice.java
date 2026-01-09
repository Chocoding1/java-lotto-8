package lotto.model;

public class PurchasePrice {

    private static final int LOTTO_PRICE_UNITS = 1000;
    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public PurchasePrice(String input) {
        int price = convertToInt(input);
        validatePrice(price);
        this.price = price;
    }

    public int lottoCount() {
        return price / LOTTO_PRICE;
    }

    public double rateOfReturn(long totalPrize) {
        return Math.round((totalPrize * 100.0 / price) * 10) / 10.0;
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수 형태여야 합니다.");
        }
    }

    private void validatePrice(int price) {
        if (price % LOTTO_PRICE_UNITS != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해 주세요.");
        }
    }
}
