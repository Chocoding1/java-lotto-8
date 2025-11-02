package lotto.model.service;

import java.util.List;
import java.util.Map;
import lotto.model.domain.CompareResult;
import lotto.model.domain.PurchasePrice;

public class PrizeCalculator {

    private static final int BONUS_PRIZE = 30000000;

    private final Map<Integer, Integer> prizeTable = Map.of(
            0, 0,
            1, 0,
            2, 0,
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
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
        if (compareResult.getMatchCount() == 6 && compareResult.isBonusMatch()) {
            return BONUS_PRIZE;
        }
        return prizeTable.get(compareResult.getMatchCount());
    }

    private double calculateProfitRate(int totalPrize, PurchasePrice purchasePrice) {
        return (double) totalPrize / purchasePrice.getPrice() * 100;
    }
}
