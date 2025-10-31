package lotto.model.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceValidatorTest {

    private final PurchasePriceValidator purchasePriceValidator = PurchasePriceValidator.getInstance();

    @ParameterizedTest
    @DisplayName("구입 금액이 1000원 이하이거나 1000으로 나누어지지 않을 시 예외 발생")
    @ValueSource(ints = {500, 1500})
    void throw_exception_when_invalid_price(int price) {
        Assertions.assertThatThrownBy(() -> purchasePriceValidator.validatePurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}