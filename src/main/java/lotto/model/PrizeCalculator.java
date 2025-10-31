package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.converter.LottoConverter;

public class PrizeCalculator {

    private final Map<Integer, Integer> prizeTable = new HashMap<>();

    private static PrizeCalculator instance;

    private PrizeCalculator() {
        initPrizeTable();
    }

    private void initPrizeTable() {
        prizeTable.put(3, 5000);
        prizeTable.put(4, 5000);
        prizeTable.put(5, 5000);
        prizeTable.put(6, 5000);
    }

    public static PrizeCalculator getInstance() {
        if (instance == null) {
            instance = new PrizeCalculator();
        }
        return instance;
    }


    public double calculate(int price, List<CompareResult> compareResults) {
        int totalPrize = getTotalPrize(compareResults);
        return Math.round((double) totalPrize / price * 100 * 10) / 10.0;
    }

    private int getTotalPrize(List<CompareResult> compareResults) {
        int totalPrize = 0;
        for (CompareResult compareResult : compareResults) {
            totalPrize += getPrize(compareResult);
        }
        return totalPrize;
    }

    private int getPrize(CompareResult compareResult) {
        if (compareResult.getMatchCount() == 6 && compareResult.isBonusMatch()) {
            return 30000000;
        }

        return prizeTable.get(compareResult.getMatchCount());
    }
}
