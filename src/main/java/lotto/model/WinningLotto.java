package lotto.model;

public class WinningLotto {

    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, BonusNumber bonusNumber) {
        validateDuplicate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public int equalCount(Lotto publishedLotto) {
        return winningNumber.equalCount(publishedLotto);
    }

    public boolean isBonus(Lotto publishedLotto) {
        return bonusNumber.isContainIn(publishedLotto);
    }

    private void validateDuplicate(Lotto winningNumber, BonusNumber bonusNumber) {
        if (winningNumber.isContain(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호 내의 숫자와 중복될 수 없습니다.");
        }
    }
}
