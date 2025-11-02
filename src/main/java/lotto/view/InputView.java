package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String getPurchasePrice() {
        printGetPurchasePriceView();
        return getInputValue();
    }

    public static String getWinningNumbers() {
        printGetWinningNumbersView();
        return getInputValue();
    }

    public static String getBonusNumber() {
        printGetBonusNumberView();
        return getInputValue();
    }

    private static void printGetPurchasePriceView() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    private static void printGetWinningNumbersView() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    private static void printGetBonusNumberView() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    private static String getInputValue() {
        return Console.readLine();
    }
}
