package lotto.controller;

import lotto.model.PurchasePrice;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
    }

    private PurchasePrice getPurchasePrice() {
        String initialPrice = inputView.getPurchasePrice();
        return new PurchasePrice(initialPrice);
    }
}
