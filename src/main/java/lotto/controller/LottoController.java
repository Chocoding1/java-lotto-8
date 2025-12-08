package lotto.controller;

import lotto.model.IssuedLotto;
import lotto.model.LottoMachine;
import lotto.model.PurchasePrice;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public LottoController(InputView inputView, LottoMachine lottoMachine, OutputView outputView) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        IssuedLotto issuedLotto = issueLotto(purchasePrice);
        printIssuedResult(issuedLotto);
        WinningNumber winningNumber = getWinningNumber();
    }

    private IssuedLotto issueLotto(PurchasePrice purchasePrice) {
        return lottoMachine.issueLotto(purchasePrice);
    }

    private PurchasePrice getPurchasePrice() {
        String initialPrice = inputView.getPurchasePrice();
        return new PurchasePrice(initialPrice);
    }

    private void printIssuedResult(IssuedLotto issuedLotto) {
        outputView.printIssuedResult(issuedLotto);
    }

    private WinningNumber getWinningNumber() {
        String winningNumber = inputView.getWinningNumber();
        return new WinningNumber(winningNumber);
    }
}
