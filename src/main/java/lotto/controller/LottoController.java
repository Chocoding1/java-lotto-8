package lotto.controller;

import static lotto.util.RetryUtils.*;

import java.util.List;
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
import lotto.util.InputUtils;
import lotto.model.validator.LottoNumberValidator;
import lotto.util.RetryUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoPublisher lottoPublisher;
    private final LottoComparator lottoComparator;
    private final LottoConverter lottoConverter;
    private final PrizeCalculator prizeCalculator;
    private final RetryUtils retryUtils;

    public LottoController(LottoPublisher lottoPublisher, LottoComparator lottoComparator,
                           LottoConverter lottoConverter, PrizeCalculator prizeCalculator, RetryUtils retryUtils) {
        this.lottoPublisher = lottoPublisher;
        this.lottoComparator = lottoComparator;
        this.lottoConverter = lottoConverter;
        this.prizeCalculator = prizeCalculator;
        this.retryUtils = retryUtils;

    }

    public void playLotto() {
        // 로또 구입 금액 입력
        PurchasePrice purchasePrice = retryUtils.tryReturnUntilSuccess(this::getPurchasePrice);

        // 로또 발행 및 출력
        PublishedLotto publishedLotto = publishAndPrintLotto(purchasePrice);

        // 당첨 로또 입력
        WinningLotto winningLotto = getWinningLotto();

        // 번호 비교
        List<CompareResult> compareResults = lottoComparator.getCompareResults(publishedLotto, winningLotto);

        // 수익률 계산
        double profitRate = prizeCalculator.getProfitRate(purchasePrice, compareResults);

        //결과 출력
        printLottoResult(compareResults, profitRate);

    }

    private PurchasePrice getPurchasePrice() {
        String initialPrice = InputView.getPurchasePrice();

        int convertedPrice = InputUtils.convertToInt(initialPrice);

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
        Lotto winningLottoNumbers = retryUtils.tryReturnUntilSuccess(this::getWinningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        retryUtils.tryRunUntilSuccess(() -> addBonusNumber(winningLotto));

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
        int bonusNumber = InputUtils.convertToInt(initialBonusNumber);

        LottoNumberValidator.validateNumber(bonusNumber);

        return bonusNumber;
    }

    private static void printLottoResult(List<CompareResult> compareResults, double profitRate) {
        ResultForView resultForView = new ResultForView();
        resultForView.getResultForView(compareResults);
        OutputView.printWinningResult(resultForView, profitRate);
    }
}
