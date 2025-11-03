package lotto.model.service.prizecalculator;

public class NumberRounder {

    public double roundTenthsPlaceValue(double profitRate) {
        return Math.round(profitRate * 10) / 10.0;
    }
}
