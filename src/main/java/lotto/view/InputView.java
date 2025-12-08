package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private static final String PURCHASE_PRICE_INPUT_NOTICE = "구입금액을 입력해 주세요.";

    public String getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_NOTICE);
        return readLine();
    }
}
