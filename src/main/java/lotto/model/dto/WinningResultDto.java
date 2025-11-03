package lotto.model.dto;

import java.util.EnumMap;
import lotto.model.domain.LottoRank;

public class WinningResultDto {

    private final EnumMap<LottoRank, Integer> rankCountMap;
//    private int bonus = 0;

    public WinningResultDto(EnumMap<LottoRank, Integer> rankCountMap) {
        this.rankCountMap = rankCountMap;
    }

    public EnumMap<LottoRank, Integer> getRankCountMap() {
        return rankCountMap;
    }

    //
//    public int getBonus() {
//        return bonus;
//    }

//    public void getResultForView(List<CompareResult> compareResults) {
//        for (CompareResult compareResult : compareResults) {
//            int matchCount = compareResult.getMatchCount();
//            boolean bonusMatch = compareResult.isBonusMatch();
//
//            if (matchCount < 3) {
//                continue;
//            }
//
//            if (matchCount == 6 && bonusMatch) {
//                bonus++;
//                continue;
//            }
//
//            resultCount.put(matchCount, resultCount.getOrDefault(matchCount, 0) + 1);
//        }
//    }
}
