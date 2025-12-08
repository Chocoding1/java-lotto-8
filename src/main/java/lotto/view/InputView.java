package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private static final String PURCHASE_PRICE_INPUT_NOTICE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_NOTICE = "당첨 번호를 입력해 주세요.";

    public String getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_NOTICE);
        return readLine();
    }

    public String getWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_NOTICE);
        return readLine();
    }
}
