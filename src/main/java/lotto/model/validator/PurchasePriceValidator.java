package lotto.model.validator;

public class PurchasePriceValidator {

    private static PurchasePriceValidator instance;

    private PurchasePriceValidator() {
    }

    public static PurchasePriceValidator getInstance() {
        if (instance == null) {
            instance = new PurchasePriceValidator();
        }
        return instance;
    }

    public void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }

        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
        }
    }
}
