package lotto.model.converter;

import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.validator.LottoNumberValidator;

public class LottoConverter {

    private static LottoConverter instance;

    private LottoConverter() {
    }

    public static LottoConverter getInstance() {
        if (instance == null) {
            instance = new LottoConverter();
        }
        return instance;
    }

    public Lotto convertToLotto(String inputValue) {
        return new Lotto(Arrays.stream(inputValue.split(","))
                .map(LottoNumberConverter::convertToInt)
                .peek(LottoNumberValidator::validateNumber)
                .toList());

    }
}
