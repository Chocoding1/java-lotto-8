package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoMachine {

    public IssuedLotto issueLotto(PurchasePrice purchasePrice) {
        int issueCount = purchasePrice.getIssueCount();

        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            lottos.add(new Lotto(getLottoNumber()));
        }

        return new IssuedLotto(lottos);
    }

    private static List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
