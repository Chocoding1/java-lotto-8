package lotto.config;

import lotto.controller.LottoController;
import lotto.view.InputView;

public class AppConfig {

    private LottoController lottoController;
    private InputView inputView;

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(inputView());
        }
        return lottoController;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }
}
