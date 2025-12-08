package lotto.model;

import lotto.Lotto;

public class WinningLotto {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        winningNumber.validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
