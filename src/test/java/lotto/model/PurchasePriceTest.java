package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {

    @ParameterizedTest
    @DisplayName("로또 구입 가격이 1000원 이하거나 1000으로 나눠지지 않으면 오류 발생")
    @ValueSource(ints = {500, 1500})
    void throw_exception_when_invalid_price(int price) {
        Assertions.assertThatThrownBy(() -> new PurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}