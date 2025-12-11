package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693a63c3dcf88191a325fa732bd0a5cb
 * https://chatgpt.com/s/t_693a63cc3eac8191ba8ddd5b04ed8f2b
 * https://chatgpt.com/s/t_693a63d276488191ae236697b1961751
 */
public class LottoMachine {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public IssuedLotto issueLotto(PurchasePrice purchasePrice) {
        int issueCount = purchasePrice.getIssueCount();
        List<Lotto> lottos = generateLottos(issueCount);
        return new IssuedLotto(lottos);
    }

    private List<Lotto> generateLottos(int issueCount) {
        return IntStream.range(0, issueCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }
}
