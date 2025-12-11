package lotto.controller;

import static lotto.util.ExceptionHandler.*;

import java.util.Map;
import java.util.function.Supplier;
import lotto.model.BonusNumber;
import lotto.model.IssuedLotto;
import lotto.model.LottoComparator;
import lotto.model.LottoMachine;
import lotto.model.PrizeCalculator;
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
    private final PrizeCalculator prizeCalculator;

    public LottoController(InputView inputView, LottoMachine lottoMachine, OutputView outputView,
                           LottoComparator lottoComparator, PrizeCalculator prizeCalculator) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
        this.lottoComparator = lottoComparator;
        this.prizeCalculator = prizeCalculator;
    }

    public void run() {
        PurchasePrice purchasePrice = wrappingSupplier(this::getPurchasePrice);
        IssuedLotto issuedLotto = issueLotto(purchasePrice);
        printIssuedResult(issuedLotto);
        WinningLotto winningLotto = createWinningLotto();
        Map<WinningGrade, Integer> result = lottoComparator.compare(issuedLotto, winningLotto);
        double rateOfReturn = prizeCalculator.calculateReturnOfRate(purchasePrice, result);
        outputView.printWinningResult(result, rateOfReturn);
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

    private WinningLotto createWinningLotto() {
        WinningNumber winningNumber = wrappingSupplier(this::getWinningNumber);
        Supplier<WinningLotto> supplier = () -> {
            BonusNumber bonusNumber = getBonusNumber();
            return new WinningLotto(winningNumber, bonusNumber);
        };
        return wrappingSupplier(supplier);
    }

    private WinningNumber getWinningNumber() {
        String winningNumber = inputView.getWinningNumber();
        return new WinningNumber(winningNumber);
    }

    private BonusNumber getBonusNumber() {
        return new BonusNumber(inputView.getBonusNumber());
    }
}
