package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호 객체 정상 생성")
    void create_bonusNumber_success() {
        //given
        String initialBonusNumber = "13";
        int bonusNumber = 13;

        //when
        BonusNumber createdBonusNumber = new BonusNumber(initialBonusNumber);

        //then
        assertThat(createdBonusNumber.getNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 정수 형태가 아닐 경우 예외 발생")
    void create_bonusNumber_fail_when_type_is_not_int() {
        //given
        String initialBonusNumber = "13j";

        //when & then
        assertThatThrownBy(() -> new BonusNumber(initialBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닐 경우 예외 발생")
    void create_bonusNumber_fail_when_number_is_out_of_range() {
        //given
        String initialBonusNumber = "123";

        //when & then
        assertThatThrownBy(() -> new BonusNumber(initialBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}