package lotto.model;

import java.util.List;

public class ResultForView {

    private int three = 0;
    private int four = 0;
    private int five = 0;
    private int bonus = 0;
    private int six = 0;

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getBonus() {
        return bonus;
    }

    public int getSix() {
        return six;
    }

    public void calculateStatistics(List<CompareResult> compareResults) {
        for (CompareResult compareResult : compareResults) {
            if (compareResult.getMatchCount() == 3) {
                three++;
            } else if (compareResult.getMatchCount() == 4) {
                four++;
            } else if (compareResult.getMatchCount() == 5) {
                five++;
            } else if (compareResult.getMatchCount() == 6 && compareResult.isBonusMatch()) {
                bonus++;
            } else if (compareResult.getMatchCount() == 6) {
                six++;
            }
        }
    }
}
