package lotto.model;

import java.util.List;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693a619dbf1c8191b7834b604e4a4811
 * https://chatgpt.com/s/t_693a61f0e90c81918a3f1ff478a2a992
 */
public class IssuedLotto {

    private final List<Lotto> lottos;

    public IssuedLotto(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return lottos.size();
    }
}
