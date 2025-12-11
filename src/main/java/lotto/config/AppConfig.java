package lotto.config;

import lotto.controller.LottoController;
import lotto.model.LottoComparator;
import lotto.model.LottoMachine;
import lotto.model.LottoNumberGenerator;
import lotto.model.PrizeCalculator;
import lotto.model.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private LottoController lottoController;
    private InputView inputView;
    private LottoMachine lottoMachine;
    private OutputView outputView;
    private LottoComparator lottoComparator;
    private PrizeCalculator prizeCalculator;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(inputView(), lottoMachine(), outputView(), lottoComparator(),
                    prizeCalculator());
        }
        return lottoController;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private LottoMachine lottoMachine() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine(lottoNumberGenerator());
        }
        return lottoMachine;
    }

    private LottoNumberGenerator lottoNumberGenerator() {
        if (lottoNumberGenerator == null) {
            lottoNumberGenerator = new RandomLottoNumberGenerator();
        }
        return lottoNumberGenerator;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private LottoComparator lottoComparator() {
        if (lottoComparator == null) {
            lottoComparator = new LottoComparator();
        }
        return lottoComparator;
    }

    private PrizeCalculator prizeCalculator() {
        if (prizeCalculator == null) {
            prizeCalculator = new PrizeCalculator();
        }
        return prizeCalculator;
    }
}
