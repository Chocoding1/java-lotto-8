package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoService;
import lotto.model.LottoParser;
import lotto.model.WinningResult;
import lotto.model.converter.PurchasePriceConverter;
import lotto.model.validator.PurchasePriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private LottoService lottoService = LottoService.getInstance();
    private LottoParser lottoParser = LottoParser.getInstance();
    private PurchasePriceValidator purchasePriceValidator = PurchasePriceValidator.getInstance();
    private PurchasePriceConverter purchasePriceConverter = PurchasePriceConverter.getInstance();

    public void playLotto() {
        // 로또 구입 금액 입력
        int purchasePrice = getPurchasePrice();

        // 로또 발행
        List<Lotto> lottos = lottoService.publishLotto(purchasePrice);

        // 발행 결과 출력
        outputView.printPublishedResult(lottos);

        // 당첨 번호 입력
        String initialWinningNumbers = inputView.getWinningNumbers();
        List<LottoNumber> winningLottoNumbers = lottoParser.convertToLottoNumbers(initialWinningNumbers);

        //보너스 번호 입력
        String initialBonusNumber = inputView.getBonusNumber();
        LottoNumber bonusNumber = lottoParser.converToLottoNumber(initialBonusNumber);
        lottoService.checkDuplicate(bonusNumber, winningLottoNumbers);

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
}
