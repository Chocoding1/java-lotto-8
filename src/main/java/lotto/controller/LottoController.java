package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.domain.CompareResult;
import lotto.model.dto.ResultForView;
import lotto.model.service.LottoComparator;
import lotto.model.service.lottopublisher.LottoPublisher;
import lotto.model.service.PrizeCalculator;
import lotto.model.domain.PublishedLotto;
import lotto.model.domain.PurchasePrice;
import lotto.model.domain.WinningLotto;
import lotto.model.service.LottoConverter;
import lotto.model.dto.PublishedLottoDto;
import lotto.util.InputUtil;
import lotto.model.validator.LottoNumberValidator;
import lotto.util.RetryUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoPublisher lottoPublisher;
    private final LottoComparator lottoComparator;
    private final LottoConverter lottoConverter;
    private final PrizeCalculator prizeCalculator;

    public LottoController(LottoPublisher lottoPublisher, LottoComparator lottoComparator,
                           LottoConverter lottoConverter, PrizeCalculator prizeCalculator) {
        this.lottoPublisher = lottoPublisher;
        this.lottoComparator = lottoComparator;
        this.lottoConverter = lottoConverter;
        this.prizeCalculator = prizeCalculator;
    }

    public void playLotto() {
        // 로또 구입 금액 입력
        PurchasePrice purchasePrice = RetryUtil.tryReturnUntilSuccess(this::getPurchasePrice);

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
        List<Integer> winningNumbers = RetryUtil.tryReturnUntilSuccess(this::getWinningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        RetryUtil.tryRunUntilSuccess(() -> addBonusNumber(winningLotto));

        return winningLotto;
    }

    private List<Integer> getWinningNumbers() {
        String initialWinningNumbers = InputView.getWinningNumbers();

        return convertToIntsAndValidate(initialWinningNumbers);
    }

    private List<Integer> convertToIntsAndValidate(String initialWinningNumbers) {
        return Arrays.stream(initialWinningNumbers.split(","))
                .map(InputUtil::convertToInt)
                .peek(LottoNumberValidator::validateNumber)
                .toList();
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

    private static void printLottoResult(List<CompareResult> compareResults, double profitRate) {
        ResultForView resultForView = new ResultForView();
        resultForView.getResultForView(compareResults);
        OutputView.printWinningResult(resultForView, profitRate);
    }
}
