package lotto.controller;

import java.util.List;
import lotto.model.CompareResult;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.model.PrizeCalculator;
import lotto.model.converter.LottoConverter;
import lotto.model.converter.LottoNumberConverter;
import lotto.model.converter.PurchasePriceConverter;
import lotto.model.validator.LottoNumberValidator;
import lotto.model.validator.PurchasePriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private LottoService lottoService = LottoService.getInstance();
    private LottoConverter lottoConverter = LottoConverter.getInstance();
    private PurchasePriceValidator purchasePriceValidator = PurchasePriceValidator.getInstance();
    private PurchasePriceConverter purchasePriceConverter = PurchasePriceConverter.getInstance();
    private PrizeCalculator prizeCalculator = PrizeCalculator.getInstance();

    public void playLotto() {
        // 로또 구입 금액 입력
        int purchasePrice = getPurchasePrice();

        // 로또 발행 및 출력
        List<Lotto> lottos = publishAndPrintLotto(purchasePrice);

        // 당첨 번호 입력
        Lotto winningLotto = getWinningNumbers();

        //보너스 번호 입력
        int bonusNumber = getBonusNumber(winningLotto);

        // 번호 비교
        List<CompareResult> compareResults = lottoService.compareLottoNumbers(lottos, winningLotto, bonusNumber);

        // 수익률 계산
        double rateOfReturn = prizeCalculator.calculate(purchasePrice, compareResults);

        //결과 출력
    }

    private int getPurchasePrice() {
        String initialPrice = inputView.getPurchasePrice();

        int purchasePrice = purchasePriceConverter.convertToInt(initialPrice);

        purchasePriceValidator.validatePurchasePrice(purchasePrice);

        return purchasePrice;
    }

    private List<Lotto> publishAndPrintLotto(int purchasePrice) {
        List<Lotto> lottos = lottoService.publishLotto(purchasePrice);

        outputView.printPublishedResult(lottos);

        return lottos;
    }

    private Lotto getWinningNumbers() {
        String initialWinningNumbers = inputView.getWinningNumbers();
        return lottoConverter.convertToLotto(initialWinningNumbers);
    }

    private int getBonusNumber(Lotto winningLotto) {
        String initialBonusNumber = inputView.getBonusNumber();

        int bonusNumber = LottoNumberConverter.convertToInt(initialBonusNumber);

        LottoNumberValidator.validateNumber(bonusNumber);

        winningLotto.validateDuplicateNumber(bonusNumber);

        return bonusNumber;
    }
}
