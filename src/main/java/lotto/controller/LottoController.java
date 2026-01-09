package lotto.controller;

import static lotto.exception.ExceptionHandler.retryUntilSuccess;

import lotto.exception.ExceptionHandler;
import lotto.model.PurchasePrice;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        PurchasePrice purchasePrice = retryUntilSuccess(this::getPurchasePrice);

    }

    private PurchasePrice getPurchasePrice() {
        String input = inputView.readPurchasePrice();
        return new PurchasePrice(input);
    }
}
