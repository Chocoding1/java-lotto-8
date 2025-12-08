package lotto.config;

import lotto.controller.LottoController;
import lotto.model.LottoComparator;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private LottoController lottoController;
    private InputView inputView;
    private LottoMachine lottoMachine;
    private OutputView outputView;
    private LottoComparator lottoComparator;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(inputView(), lottoMachine(), outputView(), lottoComparator());
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
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
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
}
