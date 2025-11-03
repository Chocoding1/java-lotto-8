package lotto.model.service.prizecalculator;

import static lotto.model.constant.LottoConstant.BONUS_MATCH_PRIZE;
import static lotto.model.constant.LottoConstant.FIVE_MATCH;
import static lotto.model.constant.LottoConstant.FIVE_MATCH_PRIZE;
import static lotto.model.constant.LottoConstant.FOUR_MATCH;
import static lotto.model.constant.LottoConstant.FOUR_MATCH_PRIZE;
import static lotto.model.constant.LottoConstant.NOT_WINNING_PRIZE;
import static lotto.model.constant.LottoConstant.SIX_MATCH;
import static lotto.model.constant.LottoConstant.SIX_MATCH_PRIZE;
import static lotto.model.constant.LottoConstant.THREE_MATCH;
import static lotto.model.constant.LottoConstant.THREE_MATCH_PRIZE;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.domain.LottoRank;
import lotto.model.domain.PurchasePrice;

public class PrizeCalculator {

    private static final int NUMBER_FOR_PERCENT = 100;

    private final Map<Integer, Integer> prizeTable = Map.of(
            THREE_MATCH, THREE_MATCH_PRIZE,
            FOUR_MATCH, FOUR_MATCH_PRIZE,
            FIVE_MATCH, FIVE_MATCH_PRIZE,
            SIX_MATCH, SIX_MATCH_PRIZE
    );
    private final NumberRounder numberRounder;

    public PrizeCalculator(NumberRounder numberRounder) {
        this.numberRounder = numberRounder;
    }

    public double getProfitRate(PurchasePrice purchasePrice, EnumMap<LottoRank, Integer> rankCountMap) {
        int totalPrize = getTotalPrize(rankCountMap);

        return numberRounder.roundTenthsPlaceValue(calculateProfitRate(totalPrize, purchasePrice));
    }

    private int getTotalPrize(EnumMap<LottoRank, Integer> rankCountMap) {
        return rankCountMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

//        return compareResults.stream()
//                .mapToInt(this::getPrize)
//                .sum();
    }

//    private int getPrize(CompareResult compareResult) {
//        int matchCount = compareResult.getMatchCount();
//
//        if (matchCount < THREE_MATCH) {
//            return NOT_WINNING_PRIZE;
//        }
//
//        if (matchCount == SIX_MATCH && compareResult.isBonusMatch()) {
//            return BONUS_MATCH_PRIZE;
//        }
//
//        return prizeTable.get(matchCount);
//    }

    private double calculateProfitRate(int totalPrize, PurchasePrice purchasePrice) {
        return (double) totalPrize / purchasePrice.getPrice() * NUMBER_FOR_PERCENT;
    }
}
