package lotto.model.domain.lotto;

import static lotto.model.constant.ErrorMessage.DUPLICATE_NUMBER_IN_LOTTO;

import java.util.List;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void addBonusNumber(int bonusNumber) {
        validateDuplicateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IN_LOTTO);
        }
    }
}
