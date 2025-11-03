package lotto.controller;

import static lotto.util.RetryUtil.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import lotto.model.domain.CompareResult;
import lotto.model.domain.LottoRank;
import lotto.model.dto.WinningResultDto;
import lotto.model.service.LottoComparator;
import lotto.model.service.lottopublisher.LottoPublisher;
import lotto.model.service.prizecalculator.PrizeCalculator;
import lotto.model.domain.lotto.PublishedLotto;
import lotto.model.domain.PurchasePrice;
import lotto.model.domain.lotto.WinningLotto;
import lotto.model.dto.PublishedLottoDto;
import lotto.util.InputUtil;
import lotto.util.LottoNumberUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoPublisher lottoPublisher;
    private final LottoComparator lottoComparator;
    private final PrizeCalculator prizeCalculator;

    public LottoController(LottoPublisher lottoPublisher, LottoComparator lottoComparator,
                           PrizeCalculator prizeCalculator) {
        this.lottoPublisher = lottoPublisher;
        this.lottoComparator = lottoComparator;
        this.prizeCalculator = prizeCalculator;
    }

    public void playLotto() {
        PurchasePrice purchasePrice = tryReturnUntilSuccess(this::getPurchasePrice);

        PublishedLotto publishedLotto = publishAndPrintLotto(purchasePrice);

        WinningLotto winningLotto = getWinningLotto();

        List<LottoRank> lottoRanks = lottoComparator.getCompareResults(publishedLotto, winningLotto);

        EnumMap<LottoRank, Integer> rankCountMap = convertToEnumMap(lottoRanks);

        double profitRate = prizeCalculator.getProfitRate(purchasePrice, rankCountMap);

        printLottoResult(rankCountMap, profitRate);

    }

    private EnumMap<LottoRank, Integer> convertToEnumMap(List<LottoRank> lottoRanks) {
        EnumMap<LottoRank, Integer> rankCountMap = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : lottoRanks) {
            rankCountMap.put(lottoRank, rankCountMap.getOrDefault(lottoRank, 0) + 1);
        }

        return rankCountMap;
    }

    private PurchasePrice getPurchasePrice() {
        String initialPrice = InputView.getPurchasePrice();

        int convertedPrice = InputUtil.convertToInt(initialPrice);

        return new PurchasePrice(convertedPrice);
    }

    private PublishedLotto publishAndPrintLotto(PurchasePrice purchasePrice) {
        PublishedLotto publishedLotto = lottoPublisher.publishLotto(purchasePrice);

        PublishedLottoDto publishedLottoDto = new PublishedLottoDto(publishedLotto);

        OutputView.printPublishedResult(publishedLottoDto);

        return publishedLotto;
    }

    private WinningLotto getWinningLotto() {
        WinningLotto winningLotto = tryReturnUntilSuccess(() -> {
            List<Integer> winningNumbers = getWinningNumbers();

            return new WinningLotto(winningNumbers);
        });

        tryRunUntilSuccess(() -> addBonusNumber(winningLotto));

        return winningLotto;
    }

    private List<Integer> getWinningNumbers() {
        String initialWinningNumbers = InputView.getWinningNumbers();

        return convertToIntsAndValidate(initialWinningNumbers);
    }

    private List<Integer> convertToIntsAndValidate(String initialWinningNumbers) {
        return Arrays.stream(InputUtil.splitInitialNumbers(initialWinningNumbers))
                .map(InputUtil::convertToInt)
                .peek(LottoNumberUtil::validateNumber)
                .toList();
    }

    private void addBonusNumber(WinningLotto winningLotto) {
        int bonusNumber = getBonusNumber();

        winningLotto.addBonusNumber(bonusNumber);
    }

    private int getBonusNumber() {
        String initialBonusNumber = InputView.getBonusNumber();
        int bonusNumber = InputUtil.convertToInt(initialBonusNumber);

        LottoNumberUtil.validateNumber(bonusNumber);

        return bonusNumber;
    }

    private static void printLottoResult(EnumMap<LottoRank, Integer> rankCountMap, double profitRate) {
        WinningResultDto winningResultDto = new WinningResultDto(rankCountMap);
        OutputView.printWinningResult(winningResultDto, profitRate);
    }
}
