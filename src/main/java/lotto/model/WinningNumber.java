package lotto.model;

import static lotto.model.ErrorMessage.*;
import static lotto.model.LottoConstants.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_69398c3e4db48191a6ad5acb9fc4cb5b
 * https://chatgpt.com/s/t_693a163ac7888191862d1fe8f43dcb79
 */
public class WinningNumber {

    private static final String COMMA = ",";

    private final List<Integer> numbers;

    public WinningNumber(String initialNumbers) {
        List<Integer> numbers = parseNumbers(initialNumbers);
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public int getCount() {
        return numbers.size();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(numbers);
    }

    private List<Integer> parseNumbers(String initialNumbers) {
        try {
            return Arrays.stream(initialNumbers.split(COMMA))
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_NOT_INTEGER);
        }
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_INVALID_COUNT + numbers.size());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || MAX_NUMBER < number) {
                throw new IllegalArgumentException(ERROR_WINNING_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = Set.copyOf(numbers);
        if (numbers.size() != nonDuplicatedNumbers.size()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_DUPLICATE);
        }
    }
}
