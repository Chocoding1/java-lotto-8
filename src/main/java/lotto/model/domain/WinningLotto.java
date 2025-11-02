package lotto.model.domain;

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

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
