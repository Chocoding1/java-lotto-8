package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_PURCHASE_PRICE_NOTICE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_NOTICE = "당첨 번호를 입력해 주세요.";

    public String readPurchasePrice() {
        System.out.println(READ_PURCHASE_PRICE_NOTICE);
        return Console.readLine();
    }

    public String readWinningNumber() {
        System.out.println(READ_WINNING_NUMBER_NOTICE);
        return Console.readLine();
    }
}
