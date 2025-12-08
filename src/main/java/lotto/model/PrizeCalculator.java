package lotto.model;

import java.util.EnumMap;

public class PrizeCalculator {

    public double calculate(PurchasePrice purchasePrice, EnumMap<WinningGrade, Integer> result) {
        int totalPrize = 0;
        for (WinningGrade winningGrade : result.keySet()) {
            totalPrize += winningGrade.getPrize() * result.get(winningGrade);
        }

        return (double) totalPrize / purchasePrice.getPrice() * 100;
    }
}
