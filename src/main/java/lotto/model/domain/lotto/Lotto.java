package lotto.model.domain.lotto;

import static lotto.model.constant.ErrorMessage.LOTTO_CONTAINS_DUPLICATE_NUMBERS;
import static lotto.model.constant.ErrorMessage.INVALID_LOTTO_LENGTH;
import static lotto.model.constant.LottoConstant.LOTTO_LENGTH;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    protected List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_CONTAINS_DUPLICATE_NUMBERS);
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
