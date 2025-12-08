package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import lotto.Lotto;

public class LottoMachine {

    public IssuedLotto issueLotto(PurchasePrice purchasePrice) {
        int issueCount = purchasePrice.getIssueCount();

        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return new IssuedLotto(lottos);
    }
}
