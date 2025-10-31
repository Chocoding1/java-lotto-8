package lotto.model.converter;

import lotto.model.validator.PurchasePriceValidator;

public class PurchasePriceConverter {

    private static PurchasePriceConverter instance;

    private PurchasePriceConverter() {
    }

    public static PurchasePriceConverter getInstance() {
        if (instance == null) {
            instance = new PurchasePriceConverter();
        }
        return instance;
    }

    public int convertToInt(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수 형태의 숫자여야 합니다.");
        }
    }
}
