package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();

        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }

        if (purchasePrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }

        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
        }

        return purchasePrice;
    }
}
