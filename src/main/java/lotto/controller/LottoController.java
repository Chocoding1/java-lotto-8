package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.model.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private LottoService lottoService = LottoService.getInstance();

    public void playLotto() {
        int purchasePrice = inputView.getPurchasePrice();

        // 로또 발행 횟수 계산
        // 로또 발행
        List<Lotto> lottos = lottoService.publishLotto(purchasePrice);

        // 발행 결과 출력
        outputView.printPublishedResult(lottos);

        // 당첨 번호 입력
        //보너스 번호 입력

        // 번호 비교

        //결과 출력
    }
}
