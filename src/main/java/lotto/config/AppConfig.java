package lotto.config;

import lotto.controller.LottoController;
import lotto.model.converter.LottoConverter;
import lotto.model.service.LottoComparator;
import lotto.model.service.LottoNumberExtractor;
import lotto.model.service.LottoPublisher;
import lotto.model.service.PrizeCalculator;
import lotto.util.RetryUtil;

public class AppConfig {

    private LottoController lottoController;
    private LottoPublisher lottoPublisher;
    private LottoNumberExtractor lottoNumberExtractor;
    private LottoComparator lottoComparator;
    private LottoConverter lottoConverter;
    private PrizeCalculator prizeCalculator;
    private RetryUtil retryUtil;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(lottoPublisher(), lottoComparator(), lottoConverter(),
                    prizeCalculator(), exceptionHandler());
        }
        return lottoController;
    }

    public LottoPublisher lottoPublisher() {
        if (lottoPublisher == null) {
            lottoPublisher = new LottoPublisher(lottoNumberExtractor());
        }
        return lottoPublisher;
    }

    public LottoNumberExtractor lottoNumberExtractor() {
        if (lottoNumberExtractor == null) {
            lottoNumberExtractor = new LottoNumberExtractor();
        }
        return lottoNumberExtractor;
    }

    public LottoComparator lottoComparator() {
        if (lottoComparator == null) {
            lottoComparator = new LottoComparator();
        }
        return lottoComparator;
    }

    public LottoConverter lottoConverter() {
        if (lottoConverter == null) {
            lottoConverter = new LottoConverter();
        }
        return lottoConverter;
    }

    public PrizeCalculator prizeCalculator() {
        if (prizeCalculator == null) {
            prizeCalculator = new PrizeCalculator();
        }
        return prizeCalculator;
    }

    public RetryUtil exceptionHandler() {
        if (retryUtil == null) {
            retryUtil = new RetryUtil();
        }
        return retryUtil;
    }
}
