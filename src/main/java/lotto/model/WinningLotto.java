package lotto.model;

public class WinningLotto {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        winningNumber.validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
