package lotto.controller;

import static lotto.exception.ExceptionHandler.retryUntilSuccess;

import lotto.exception.ExceptionHandler;
import lotto.model.LottoPublisher;
import lotto.model.PublishedLotto;
import lotto.model.PurchasePrice;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        PurchasePrice purchasePrice = retryUntilSuccess(this::getPurchasePrice);
        PublishedLotto publishedLotto = LottoPublisher.publish(purchasePrice);
    }

    private PurchasePrice getPurchasePrice() {
        String input = inputView.readPurchasePrice();
        return new PurchasePrice(input);
    }
}
