package lotto.controller;

import static lotto.exception.ExceptionHandler.retryUntilSuccess;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoComparator;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
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
        WinningLotto winningLotto = getWinningLotto();
        LottoComparator lottoComparator = new LottoComparator(publishedLotto, winningLotto);
        WinningResult winningResult = lottoComparator.compare();
        double rateOfReturn = winningResult.rateOfReturn(purchasePrice);
    }

    private PurchasePrice getPurchasePrice() {
        String input = inputView.readPurchasePrice();
        return new PurchasePrice(input);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumber = retryUntilSuccess(this::getWinningNumber);
        return retryUntilSuccess(() -> createWinningLotto(winningNumber));
    }

    private Lotto getWinningNumber() {
        String input = inputView.readWinningNumber();
        return LottoParser.parse(input);
    }

    private WinningLotto createWinningLotto(Lotto winningNumber) {
        BonusNumber bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private BonusNumber getBonusNumber() {
        String input = inputView.readBonusNumber();
        return new BonusNumber(input);
    }
}
