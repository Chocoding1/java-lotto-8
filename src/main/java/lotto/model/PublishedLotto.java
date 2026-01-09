package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<WinningGrade> compare(WinningLotto winningLotto) {
        List<WinningGrade> result = new ArrayList<>();
        for (Lotto publishedLotto : lottos) {
            int equalCount = winningLotto.equalCount(publishedLotto);
            boolean bonus = winningLotto.isBonus(publishedLotto);
            result.add(WinningGrade.of(equalCount, bonus));
        }
        return result;
    }
}
