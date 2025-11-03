package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberUtilTest {

    @ParameterizedTest
    @DisplayName("1 ~ 45 사이의 숫자가 아니면 예외 발생")
    @ValueSource(ints = {0, -1, 46})
    void throw_exception_when_invalid_number(int number) {
        Assertions.assertThatThrownBy(() -> LottoNumberUtil.validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}