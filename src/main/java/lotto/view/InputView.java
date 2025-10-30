package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getPurchasePrice() {
        printGetPurchasePriceView();
        String initialPurchasePrice = getInitialPurchasePrice();

        int purchasePrice = convertToInt(initialPurchasePrice);
        validatePurchasePrice(purchasePrice);

        return purchasePrice;
    }

    private static void printGetPurchasePriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static String getInitialPurchasePrice() {
        return Console.readLine();
    }

    private int convertToInt(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }

        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
        }
    }
}
