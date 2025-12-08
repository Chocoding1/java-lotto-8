package lotto.model;

public class PurchasePrice {

    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public PurchasePrice(String initialPrice) {
        int price = convertToInt(initialPrice);
        validateUnits(price);
        this.price = price;
    }

    public int getIssueCount() {
        return price / LOTTO_PRICE;
    }

    private int convertToInt(String initialPrice) {
        try {
            return Integer.parseInt(initialPrice);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수 형태여야 합니다.");
        }
    }

    private void validateUnits(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
