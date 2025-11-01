package lotto.model;

public class PurchasePrice {

    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public PurchasePrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
        }
    }

    public int getLottoQuantity() {
        return price / LOTTO_PRICE;
    }
}
