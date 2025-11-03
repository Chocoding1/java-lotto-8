package lotto.model.domain;

import static lotto.exception.ErrorMessage.PRICE_LESS_THAN_1000;
import static lotto.exception.ErrorMessage.PRICE_NOT_UNITS_OF_1000;

public class PurchasePrice {

    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public PurchasePrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_1000);
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_NOT_UNITS_OF_1000);
        }
    }

    public int getPrice() {
        return price;
    }

    public int getLottoQuantity() {
        return price / LOTTO_PRICE;
    }
}
