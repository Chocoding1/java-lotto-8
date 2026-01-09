package lotto.controller;

import static lotto.exception.ExceptionHandler.retryUntilSuccess;

import lotto.model.Lotto;
import lotto.util.LottoParser;
import lotto.util.LottoPublisher;
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
        Lotto winningNumber = retryUntilSuccess(this::getWinningNumber);
    }

    private Lotto getWinningNumber() {
        String input = inputView.readWinningNumber();
        return LottoParser.parse(input);
    }

    private PurchasePrice getPurchasePrice() {
        String input = inputView.readPurchasePrice();
        return new PurchasePrice(input);
    }
}
