package lotto.model.domain;

import static lotto.exception.ErrorMessage.PRICE_LESS_THAN_LOTTO_PRICE;
import static lotto.exception.ErrorMessage.PRICE_NOT_UNITS_OF_LOTTO_PRICE;

public class PurchasePrice {

    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public PurchasePrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_LOTTO_PRICE);
        }

        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_NOT_UNITS_OF_LOTTO_PRICE);
        }
    }

    public int getPrice() {
        return price;
    }

    public int getLottoQuantity() {
        return price / LOTTO_PRICE;
    }
}
