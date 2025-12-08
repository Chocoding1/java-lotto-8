package lotto.controller;

import java.util.EnumMap;
import lotto.model.BonusNumber;
import lotto.model.IssuedLotto;
import lotto.model.LottoComparator;
import lotto.model.LottoMachine;
import lotto.model.PurchasePrice;
import lotto.model.WinningGrade;
import lotto.model.WinningLotto;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private final OutputView outputView;
    private final LottoComparator lottoComparator;

    public LottoController(InputView inputView, LottoMachine lottoMachine, OutputView outputView,
                           LottoComparator lottoComparator) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
        this.lottoComparator = lottoComparator;
    }

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        IssuedLotto issuedLotto = issueLotto(purchasePrice);
        printIssuedResult(issuedLotto);
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        EnumMap<WinningGrade, Integer> result = lottoComparator.compare(issuedLotto, winningLotto);
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

    private BonusNumber getBonusNumber() {
        return new BonusNumber(inputView.getBonusNumber());
    }
}
