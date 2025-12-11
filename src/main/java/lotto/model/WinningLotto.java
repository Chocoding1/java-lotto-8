package lotto.model;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693a143100fc819184fe709fbd910df3
 * https://chatgpt.com/s/t_693a14935cf0819185d6bffe03d60b92
 */
public class WinningLotto {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        bonusNumber.validateDuplicate(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningGrade compare(Lotto lotto) {
        int matchCount = winningNumber.getMatchCount(lotto);
        boolean bonusMatch = bonusNumber.isMatch(lotto);

        return WinningGrade.of(matchCount, bonusMatch);
    }
}
