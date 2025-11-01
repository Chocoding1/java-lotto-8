package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void addBonusNumber(int bonusNumber) {
        lotto.validateDuplicateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
