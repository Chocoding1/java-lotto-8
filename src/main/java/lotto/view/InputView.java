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

    public int getPurchasePrice() {
        printGetPurchasePriceView();
        return convertToInt(getInputValue());
    }

    public String getWinningNumbers() {
        return getInputValue();
    }

    public String getBonusNumber() {
        return getInputValue();
    }

    private static void printGetPurchasePriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static String getInputValue() {
        return Console.readLine();
    }

    private int convertToInt(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수 형태의 숫자여야 합니다.");
        }
    }
}
