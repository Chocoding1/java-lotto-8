package lotto.model.domain;

import static lotto.model.constant.ErrorMessage.LOTTO_CONTAINS_DUPLICATE_NUMBERS;
import static lotto.model.constant.ErrorMessage.DUPLICATE_NUMBER_IN_LOTTO;
import static lotto.model.constant.ErrorMessage.INVALID_LOTTO_LENGTH;
import static lotto.model.constant.LottoConstant.LOTTO_LENGTH;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> getNumbers() {
        return numbers;
    }

    public void validateDuplicateNumber(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IN_LOTTO);
        }
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

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
