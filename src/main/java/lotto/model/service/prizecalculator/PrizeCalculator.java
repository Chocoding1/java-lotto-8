package lotto.model.service.prizecalculator;

import java.util.EnumMap;
import lotto.model.domain.LottoRank;
import lotto.model.domain.PurchasePrice;

public class PrizeCalculator {

    private static final int NUMBER_FOR_PERCENT = 100;

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
    }

    private double calculateProfitRate(int totalPrize, PurchasePrice purchasePrice) {
        return (double) totalPrize / purchasePrice.getPrice() * NUMBER_FOR_PERCENT;
    }
}
