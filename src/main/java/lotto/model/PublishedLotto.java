package lotto.model;

import java.util.Collections;
import java.util.List;

public class PublishedLotto {

    private final List<Lotto> lottos;

    public PublishedLotto(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int count() {
        return lottos.size();
    }
}
