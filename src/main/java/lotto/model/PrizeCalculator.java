package lotto.model;

import java.util.Map;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693a67ad661881919f196f62b4fcbefc
 * https://chatgpt.com/s/t_693a67ef4490819197b1e79aa75fc877
 */
public class PrizeCalculator {

    public double calculateReturnOfRate(PurchasePrice purchasePrice, Map<WinningGrade, Integer> result) {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (totalPrize * 100.0) / purchasePrice.getPrice();
    }
}
