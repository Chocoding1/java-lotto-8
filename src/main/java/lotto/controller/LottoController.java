package lotto.controller;

import lotto.model.IssuedLotto;
import lotto.model.LottoMachine;
import lotto.model.PurchasePrice;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        IssuedLotto issuedLotto = issueLotto(purchasePrice);
    }

    private IssuedLotto issueLotto(PurchasePrice purchasePrice) {
        return lottoMachine.issueLotto(purchasePrice);
    }

    private PurchasePrice getPurchasePrice() {
        String initialPrice = inputView.getPurchasePrice();
        return new PurchasePrice(initialPrice);
    }
}
