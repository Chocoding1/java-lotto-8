package lotto.model;

import static lotto.model.ErrorMessage.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isMatch(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_INVALID_COUNT);
        }
    }
}
