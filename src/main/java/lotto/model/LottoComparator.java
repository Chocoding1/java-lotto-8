package lotto.model;

import static lotto.model.WinningGrade.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.Lotto;

public class LottoComparator {

    private final EnumMap<WinningGrade, Integer> compareResult = new EnumMap<>(WinningGrade.class);

    public LottoComparator() {
        compareResult.put(FIRST, 0);
        compareResult.put(SECOND, 0);
        compareResult.put(THIRD, 0);
        compareResult.put(FOURTH, 0);
        compareResult.put(FIFTH, 0);
    }

    public EnumMap<WinningGrade, Integer> compare(IssuedLotto issuedLotto, WinningLotto winningLotto) {
        checkMatchCount(issuedLotto.getLottos(), winningLotto);
        return compareResult;
    }

    private void checkMatchCount(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            List<Integer> issuedNumbers = new ArrayList<>(lotto.getNumbers());
            List<Integer> winningNumbers = winningLotto.getWinningNumber().getNumbers();
            int bonusNumber = winningLotto.getBonusNumber().getNumber();

            boolean isBonus = false;
            int matchCount = 0;
            if (issuedNumbers.contains(bonusNumber)) {
                isBonus = true;
                matchCount++;
            }
            issuedNumbers.retainAll(winningNumbers);
            matchCount += issuedNumbers.size();

            WinningGrade winningGrade = getWinningGrade(matchCount, isBonus);
            if (winningGrade != null) {
                compareResult.put(winningGrade, compareResult.get(winningGrade) + 1);
            }

        }
    }

    private WinningGrade getWinningGrade(int matchCount, boolean isBonus) {
        if (matchCount < 6) {
            for (WinningGrade winningGrade : compareResult.keySet()) {
                if (winningGrade.getMatchCount() == matchCount) {
                    return winningGrade;
                }
            }
            return null;
        }

        if (isBonus) {
            return SECOND;
        }

        return FIRST;
    }
}
