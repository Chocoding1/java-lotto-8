package lotto.model;

import java.util.List;
import lotto.Lotto;

public class IssuedLotto {

    private final List<Lotto> lottos;

    public IssuedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
