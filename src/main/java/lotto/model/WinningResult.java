package lotto.model;

import java.util.EnumMap;
import java.util.List;

public class WinningResult {

    private final EnumMap<WinningGrade, Integer> result;

    public WinningResult(List<WinningGrade> compareResult) {
        this.result = getResult(compareResult);
    }

    private EnumMap<WinningGrade, Integer> getResult(List<WinningGrade> compareResult) {
        EnumMap<WinningGrade, Integer> result = new EnumMap<>(WinningGrade.class);
        for (WinningGrade winningGrade : compareResult) {
            result.put(winningGrade, result.getOrDefault(winningGrade, 0) + 1);
        }
        return result;
    }

    public double rateOfReturn(PurchasePrice purchasePrice) {
        long totalPrize = getTotalPrize();
        return purchasePrice.rateOfReturn(totalPrize);
    }

    public int getMatchCount(WinningGrade winningGrade) {
        return result.getOrDefault(winningGrade, 0);
    }

    private long getTotalPrize() {
        long totalPrize = 0;
        for (WinningGrade winningGrade : result.keySet()) {
            totalPrize += (long) winningGrade.getPrize() * result.get(winningGrade);
        }
        return totalPrize;
    }
}
