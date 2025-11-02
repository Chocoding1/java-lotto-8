package lotto.config;

import lotto.controller.LottoController;
import lotto.hadler.ExceptionHandler;
import lotto.hadler.ExceptionHandlerImpl;
import lotto.model.converter.LottoConverter;
import lotto.model.service.LottoComparator;
import lotto.model.service.LottoPublisher;
import lotto.model.service.PrizeCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private LottoController lottoController;
    private InputView inputView;
    private OutputView outputView;
    private LottoPublisher lottoPublisher;
    private LottoComparator lottoComparator;
    private LottoConverter lottoConverter;
    private PrizeCalculator prizeCalculator;
    private ExceptionHandler exceptionHandler;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(inputView(), outputView(), lottoPublisher(), lottoComparator(),
                    lottoConverter(), prizeCalculator(), exceptionHandler());
        }
        return lottoController;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
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
            exceptionHandler = new ExceptionHandlerImpl();
        }
        return exceptionHandler;
    }
}
