package lotto.model.dto;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.PublishedLotto;

public class PublishedLottoDto {

    private final int lottoCount;
    private final List<Lotto> lottos;

    public PublishedLottoDto(PublishedLotto publishedLotto) {
        this.lottoCount = publishedLotto.getLottoCount();
        this.lottos = publishedLotto.getLottos();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
