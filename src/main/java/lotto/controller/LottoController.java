package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoService;
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

    public void playLotto() {
        // 로또 구입 금액 입력
        int purchasePrice = getPurchasePrice();

        // 로또 발행 및 출력
        publishAndPrintLotto(purchasePrice);

        // 당첨 번호 입력
        Lotto winningLotto = getWinningNumbers();

        //보너스 번호 입력
        int bonusNumber = getBonusNumber();

        // 번호 비교
//        List<WinningResult> winningResult = lottoService.getWinningResult(lottos, winningLottoNumbers, bonusNumber);

        //결과 출력
    }

    private int getPurchasePrice() {
        String initialPrice = inputView.getPurchasePrice();

        int purchasePrice = purchasePriceConverter.convertToInt(initialPrice);

        purchasePriceValidator.validatePurchasePrice(purchasePrice);

        return purchasePrice;
    }

    private void publishAndPrintLotto(int purchasePrice) {
        List<Lotto> lottos = lottoService.publishLotto(purchasePrice);

        outputView.printPublishedResult(lottos);
    }

    private Lotto getWinningNumbers() {
        String initialWinningNumbers = inputView.getWinningNumbers();
        return lottoConverter.convertToLotto(initialWinningNumbers);
    }

    private int getBonusNumber() {
        String initialBonusNumber = inputView.getBonusNumber();

        int bonusNumber = LottoNumberConverter.convertToInt(initialBonusNumber);

        LottoNumberValidator.validateNumber(bonusNumber);

        return bonusNumber;
    }
}
