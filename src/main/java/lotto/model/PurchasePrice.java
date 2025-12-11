package lotto.model;

import static lotto.model.ErrorMessage.*;
import static lotto.model.LottoConstants.*;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693a68c2d8408191993a4a34c3d6f452
 */
public class PurchasePrice {

    private final int price;

    public PurchasePrice(String initialPrice) {
        int price = convertToInt(initialPrice);
        validateAmount(price);
        validateUnits(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getIssueCount() {
        return price / LOTTO_PRICE;
    }

    private int convertToInt(String initialPrice) {
        try {
            return Integer.parseInt(initialPrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PRICE_NOT_INTEGER);
        }
    }

    private void validateAmount(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_PRICE_AMOUNT);
        }
    }
    private void validateUnits(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PRICE_UNITS);
        }
    }
}
