package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String getPurchasePrice() {
        printGetPurchasePriceView();
        return getInputValue();
    }

    public String getWinningNumbers() {
        printGetWinningNumbersView();
        return getInputValue();
    }

    public String getBonusNumber() {
        printGetBonusNumberView();
        return getInputValue();
    }

    private static void printGetPurchasePriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printGetWinningNumbersView() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printGetBonusNumberView() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static String getInputValue() {
        return Console.readLine();
    }
}
