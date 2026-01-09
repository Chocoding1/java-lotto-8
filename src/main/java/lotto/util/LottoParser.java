package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class LottoParser {

    private static final String COMMA = ",";


    public static Lotto parse(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(COMMA))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수 형태로 입력해 주세요.");
        }
    }
}
