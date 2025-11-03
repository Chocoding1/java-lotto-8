package lotto.model.domain.lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {


    @Test
    @DisplayName("보너스 번호 정상 초기화")
    void addBonusNumber_success() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        winningLotto.addBonusNumber(bonusNumber);

        // then
        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외 발생")
    void addBonusNumber_fail_when_duplicate_bonus_number() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        int duplicateBonusNumber = 6;

        // when & then
        Assertions.assertThatThrownBy(() -> winningLotto.addBonusNumber(duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}