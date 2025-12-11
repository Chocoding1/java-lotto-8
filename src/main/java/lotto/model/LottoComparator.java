package lotto.model;

import static lotto.model.WinningGrade.*;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693a145bb4288191824018dd7cf0c5cc
 * https://chatgpt.com/s/t_693a5bf2723c81918469271f66fda96a
 * https://chatgpt.com/s/t_693a5c22089c8191a983c99c204943eb
 */
public class LottoComparator {

    public Map<WinningGrade, Integer> compare(IssuedLotto issuedLotto, WinningLotto winningLotto) {
        EnumMap<WinningGrade, Integer> compareResult = initResultMap();

        for (Lotto lotto : issuedLotto.getLottos()) {
            WinningGrade winningGrade = winningLotto.compare(lotto);
            if (winningGrade != NONE) {
                compareResult.put(winningGrade, compareResult.get(winningGrade) + 1);
            }
        }
        return Collections.unmodifiableMap(compareResult);
    }

    private EnumMap<WinningGrade, Integer> initResultMap() {
        EnumMap<WinningGrade, Integer> map = new EnumMap<>(WinningGrade.class);

        for (WinningGrade winningGrade : values()) {
            if (winningGrade != NONE) {
                map.put(winningGrade, 0);
            }
        }
        return map;
    }
}
