package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class WinningNumber {

    private static final String COMMA = ",";
    private static final int WINNING_NUMBER_LENGTH = 6;

    private final List<Integer> numbers;

    public WinningNumber(String initialNumbers) {
        this.numbers = parseNumbers(initialNumbers);
    }

    public int getCount() {
        return numbers.size();
    }

    private List<Integer> parseNumbers(String initialNumbers) {
        String[] tokens = initialNumbers.split(COMMA);
        Integer[] numbers = convertToInt(tokens);
        validateNumbers(numbers);
        return Stream.of(numbers).toList();
    }

    private Integer[] convertToInt(String[] tokens) {
        try {
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toArray(Integer[]::new);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호 내에 쉼표 외의 문자가 존재합니다.");
        }
    }

    private void validateNumbers(Integer[] numbers) {
        validateCount(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateCount(Integer[] numbers) {
        if (numbers.length != WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 6개여야 합니다. 현재 개수: " + numbers.length);
        }
    }

    private void validateDuplicatedNumber(Integer[] numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(Arrays.asList(numbers));
        if (numbers.length != nonDuplicatedNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호 내에 중복된 숫자가 존재합니다.");
        }
    }
}
