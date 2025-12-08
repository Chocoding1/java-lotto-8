package lotto.config;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private LottoController lottoController;
    private InputView inputView;
    private LottoMachine lottoMachine;
    private OutputView outputView;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(inputView(), lottoMachine(), outputView());
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
}
