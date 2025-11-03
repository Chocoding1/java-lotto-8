package lotto.model.service;

import java.util.List;
import java.util.Map;
import lotto.model.domain.CompareResult;
import lotto.model.domain.PurchasePrice;

public class PrizeCalculator {

    private static final int ZERO_MATCH = 0;
    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private static final int THREE_MATCH_PRIZE = 5000;
    private static final int FOUR_MATCH_PRIZE = 50000;
    private static final int FIVE_MATCH_PRIZE = 1500000;
    private static final int BONUS_MATCH_PRIZE = 30000000;
    private static final int SIX_MATCH_PRIZE = 2000000000;

    private final Map<Integer, Integer> prizeTable = Map.of(
            THREE_MATCH, THREE_MATCH_PRIZE,
            FOUR_MATCH, FOUR_MATCH_PRIZE,
            FIVE_MATCH, FIVE_MATCH_PRIZE,
            SIX_MATCH, SIX_MATCH_PRIZE
    );

    public double getProfitRate(PurchasePrice purchasePrice, List<CompareResult> compareResults) {
        int totalPrize = getTotalPrize(compareResults);
        return Math.round(calculateProfitRate(totalPrize, purchasePrice) * 10) / 10.0;
    }

    private int getTotalPrize(List<CompareResult> compareResults) {
        return compareResults.stream()
                .mapToInt(this::getPrize)
                .sum();
    }

    private int getPrize(CompareResult compareResult) {
        int matchCount = compareResult.getMatchCount();

        if (matchCount < 3) {
            return ZERO_MATCH;
        }

        if (matchCount == 6 && compareResult.isBonusMatch()) {
            return BONUS_MATCH_PRIZE;
        }

        return prizeTable.get(matchCount);
    }

    private double calculateProfitRate(int totalPrize, PurchasePrice purchasePrice) {
        return (double) totalPrize / purchasePrice.getPrice() * 100;
    }
}
