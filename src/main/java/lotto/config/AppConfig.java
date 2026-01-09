package lotto.config;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private LottoController lottoController;
    private InputView inputView;
    private OutputView outputView;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(inputView(), outputView());
        }
        return lottoController;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }
}
