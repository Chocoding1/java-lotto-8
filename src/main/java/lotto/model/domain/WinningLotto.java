package lotto.model.domain;

import static lotto.model.constant.ErrorMessage.DUPLICATE_NUMBER_IN_LOTTO;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateDuplicateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IN_LOTTO);
        }
    }

//    public void addBonusNumber(int bonusNumber) {
//        lotto.validateDuplicateNumber(bonusNumber);
//        this.bonusNumber = bonusNumber;
//    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
