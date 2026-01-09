package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_PURCHASE_PRICE_NOTICE = "구입금액을 입력해 주세요.";

    public String readPurchasePrice() {
        System.out.println(READ_PURCHASE_PRICE_NOTICE);
        return Console.readLine();
    }
}
