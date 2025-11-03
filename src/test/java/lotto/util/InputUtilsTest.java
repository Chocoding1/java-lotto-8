package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputUtilTest {

    @ParameterizedTest
    @DisplayName("정수 형태의 입력값이 아니면 예외 발생")
    @ValueSource(strings = {"ab", "1*2", ":3", "(", " ", "\t"})
    void throw_exception_when_invalid_input(String inputValue) {
        Assertions.assertThatThrownBy(() -> InputUtil.convertToInt(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}