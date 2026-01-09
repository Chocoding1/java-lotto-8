package lotto.controller;

import static lotto.exception.ExceptionHandler.retryUntilSuccess;

import lotto.model.LottoPublisher;
import lotto.model.PublishedLotto;
import lotto.model.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchasePrice purchasePrice = retryUntilSuccess(this::getPurchasePrice);
        PublishedLotto publishedLotto = LottoPublisher.publish(purchasePrice);
        outputView.printPublishedLotto(publishedLotto);
    }

    private PurchasePrice getPurchasePrice() {
        String input = inputView.readPurchasePrice();
        return new PurchasePrice(input);
    }
}
