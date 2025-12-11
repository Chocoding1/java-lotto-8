package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호 정상 입력")
    void create_winningNumber_success() {
        //given
        String initialNumbers = "1,2,3,4,5,6";

        //when
        WinningNumber winningNumber = new WinningNumber(initialNumbers);

        //then
        assertThat(winningNumber.getCount()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5*6", "1,2,3,4,5,*6", "1,2,3,4,5 6"})
    @DisplayName("당첨 번호 내에 쉼표 외의 문자 존재 시 예외 발생")
    void create_winningNumber_fail_when_contain_invalid_string(String invalidNumbers) {
        //when & then
        assertThatThrownBy(() -> new WinningNumber(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호의 수가 6개가 아닐 경우 예외 발생")
    void create_winningNumber_fail_when_numbers_count_is_not_six() {
        //given
        String invalidNumbers = "1,2,3,4,5";

        //when & then
        assertThatThrownBy(() -> new WinningNumber(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 1~45 범위 밖의 숫자가 존재할 경우 예외 발생")
    void create_winningNumber_fail_when_number_is_out_of_range() {
        //given
        String invalidNumbers = "1,2,3,4,5,50";

        //when & then
        assertThatThrownBy(() -> new WinningNumber(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 내에 중복된 숫자가 존재할 경우 예외 발생")
    void create_winningNumber_fail_when_numbers_contain_duplicate_number() {
        //given
        String invalidNumbers = "1,2,3,4,5,5";

        //when & then
        assertThatThrownBy(() -> new WinningNumber(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}