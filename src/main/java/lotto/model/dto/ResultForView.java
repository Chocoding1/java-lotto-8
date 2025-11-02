package lotto.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.domain.CompareResult;

public class ResultForView {

    private final Map<Integer, Integer> resultCount = new HashMap<>();
    private int bonus = 0;

    public Map<Integer, Integer> getResultCount() {
        return resultCount;
    }

    public int getBonus() {
        return bonus;
    }

    public void getResultForView(List<CompareResult> compareResults) {
        for (CompareResult compareResult : compareResults) {
            int matchCount = compareResult.getMatchCount();
            boolean bonusMatch = compareResult.isBonusMatch();

            if (matchCount < 3) {
                continue;
            }

            if (matchCount == 6 && bonusMatch) {
                bonus++;
            }

            resultCount.put(matchCount, resultCount.getOrDefault(matchCount, 0) + 1);
        }
    }
}
