package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @Test
    @DisplayName("구입 금액 객체 정상 생성")
    void create_PurchasePrice_success() {
        //given
        String initialPrice = "1000";
        int price = 1000;

        //when
        PurchasePrice purchasePrice = new PurchasePrice(initialPrice);

        //then
        assertThat(purchasePrice.getPrice()).isEqualTo(price);
    }

    @Test
    @DisplayName("구입 금액이 정수 형태가 아닐 경우 예외 발생")
    void create_PurchasePrice_fail_when_type_is_not_int() {
        //given
        String initialPrice = "1000j";

        //when & then
        assertThatThrownBy(() -> new PurchasePrice(initialPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구입 금액이 1000원 이하일 경우 예외 발생")
    void create_PurchasePrice_fail_when_price_is_less_than_1000() {
        //given
        String initialPrice = "500";

        //when & then
        assertThatThrownBy(() -> new PurchasePrice(initialPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외 발생")
    void create_PurchasePrice_fail_when_price_is_not_1000_units() {
        //given
        String initialPrice = "1500";

        //when & then
        assertThatThrownBy(() -> new PurchasePrice(initialPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}