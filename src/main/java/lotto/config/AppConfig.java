package lotto.config;

import lotto.controller.LottoController;
import lotto.exception.ExceptionHandler;
import lotto.model.converter.LottoConverter;
import lotto.model.service.LottoComparator;
import lotto.model.service.LottoPublisher;
import lotto.model.service.PrizeCalculator;

public class AppConfig {

    private LottoController lottoController;
    private LottoPublisher lottoPublisher;
    private LottoComparator lottoComparator;
    private LottoConverter lottoConverter;
    private PrizeCalculator prizeCalculator;
    private ExceptionHandler exceptionHandler;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(lottoPublisher(), lottoComparator(),
                    lottoConverter(), prizeCalculator(), exceptionHandler());
        }
        return lottoController;
    }

    public LottoPublisher lottoPublisher() {
        if (lottoPublisher == null) {
            lottoPublisher = new LottoPublisher();
        }
        return lottoPublisher;
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

    public ExceptionHandler exceptionHandler() {
        if (exceptionHandler == null) {
            exceptionHandler = new ExceptionHandler();
        }
        return exceptionHandler;
    }
}
