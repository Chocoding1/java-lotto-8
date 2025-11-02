package lotto.controller;

import java.util.List;
import lotto.hadler.ExceptionHandler;
import lotto.model.domain.CompareResult;
import lotto.model.domain.Lotto;
import lotto.model.dto.ResultForView;
import lotto.model.service.LottoComparator;
import lotto.model.service.LottoPublisher;
import lotto.model.service.PrizeCalculator;
import lotto.model.domain.PublishedLotto;
import lotto.model.domain.PurchasePrice;
import lotto.model.domain.WinningLotto;
import lotto.model.converter.LottoConverter;
import lotto.model.dto.PublishedLottoDto;
import lotto.util.InputUtil;
import lotto.model.validator.LottoNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoPublisher lottoPublisher;
    private final LottoComparator lottoComparator;
    private final LottoConverter lottoConverter;
    private final PrizeCalculator prizeCalculator;
    private final ExceptionHandler exceptionHandler;

    public LottoController(LottoPublisher lottoPublisher,
                           LottoComparator lottoComparator, LottoConverter lottoConverter,
                           PrizeCalculator prizeCalculator, ExceptionHandler exceptionHandler) {
        this.lottoPublisher = lottoPublisher;
        this.lottoComparator = lottoComparator;
        this.lottoConverter = lottoConverter;
        this.prizeCalculator = prizeCalculator;
        this.exceptionHandler = exceptionHandler;
    }

    public void playLotto() {
        // 로또 구입 금액 입력
        PurchasePrice purchasePrice = exceptionHandler.trySupplierUntilSuccess(this::getPurchasePrice);

        // 로또 발행 및 출력
        PublishedLotto publishedLotto = publishAndPrintLotto(purchasePrice);

        // 당첨 로또 입력
        WinningLotto winningLotto = getWinningLotto();

        // 번호 비교
        List<CompareResult> compareResults = lottoComparator.getCompareResults(publishedLotto, winningLotto);

        // 수익률 계산
        double profitRate = prizeCalculator.getProfitRate(purchasePrice, compareResults);

        //결과 출력
        ResultForView resultForView = new ResultForView();
        resultForView.getResultForView(compareResults);
        OutputView.printWinningResult(resultForView, profitRate);

    }

    private PurchasePrice getPurchasePrice() {
        String initialPrice = InputView.getPurchasePrice();

        int convertedPrice = InputUtil.convertToInt(initialPrice);

        return new PurchasePrice(convertedPrice);
    }

    private PublishedLotto publishAndPrintLotto(PurchasePrice purchasePrice) {
        PublishedLotto publishedLotto = lottoPublisher.publishLotto(purchasePrice);

        PublishedLottoDto publishedLottoDto = convertToPublishedLottoDto(publishedLotto);

        OutputView.printPublishedResult(publishedLottoDto);

        return publishedLotto;
    }

    private PublishedLottoDto convertToPublishedLottoDto(PublishedLotto publishedLotto) {
        return PublishedLottoDto.of(publishedLotto.getLottoCount(), publishedLotto.getLottos());
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLottoNumbers = exceptionHandler.trySupplierUntilSuccess(this::getWinningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        exceptionHandler.tryRunnableUntilSuccess(() -> addBonusNumber(winningLotto));

        return winningLotto;
    }

    private Lotto getWinningNumbers() {
        String initialWinningNumbers = InputView.getWinningNumbers();

        return lottoConverter.convertToLotto(initialWinningNumbers);
    }

    private void addBonusNumber(WinningLotto winningLotto) {
        int bonusNumber = getBonusNumber();

        winningLotto.addBonusNumber(bonusNumber);
    }

    private int getBonusNumber() {
        String initialBonusNumber = InputView.getBonusNumber();
        int bonusNumber = InputUtil.convertToInt(initialBonusNumber);

        LottoNumberValidator.validateNumber(bonusNumber);

        return bonusNumber;
    }
}
