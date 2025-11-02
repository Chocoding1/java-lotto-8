package lotto.model.domain;

import java.util.List;
import lotto.Lotto;

public class PublishedLotto {

    private final List<Lotto> lottos;

    public PublishedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

}
