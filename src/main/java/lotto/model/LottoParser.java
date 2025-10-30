package lotto.model;

import java.util.Arrays;
import java.util.List;

public class LottoParser {

    private static LottoParser instance;

    private LottoParser() {
    }

    public static LottoParser getInstance() {
        if (instance == null) {
            instance = new LottoParser();
        }
        return instance;
    }

    public List<LottoNumber> convertToLottoNumbers(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(LottoNumber::new)
                .toList();
    }

    public LottoNumber converToLottoNumber(String initialBonusNumber) {
        return new LottoNumber(initialBonusNumber);
    }
}
