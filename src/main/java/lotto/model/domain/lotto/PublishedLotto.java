package lotto.model.domain.lotto;

import java.util.List;

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

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
