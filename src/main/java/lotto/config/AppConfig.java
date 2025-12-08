package lotto.config;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.view.InputView;

public class AppConfig {

    private LottoController lottoController;
    private InputView inputView;
    private LottoMachine lottoMachine;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(inputView(), lottoMachine());
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
}
