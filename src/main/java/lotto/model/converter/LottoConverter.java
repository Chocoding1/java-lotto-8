package lotto.model.converter;

import java.util.Arrays;
import lotto.Lotto;
import lotto.model.validator.LottoNumberValidator;
import lotto.util.InputUtil;

public class LottoConverter {

    public Lotto convertToLotto(String inputValue) {
        return new Lotto(Arrays.stream(inputValue.split(",")) // 문자열 파싱
                .map(InputUtil::convertToInt) // 정수 변환
                .peek(LottoNumberValidator::validateNumber) // 로또 번호 검증
                .toList());

    }
}
