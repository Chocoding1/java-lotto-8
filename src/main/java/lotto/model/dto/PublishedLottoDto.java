package lotto.model.dto;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.PublishedLotto;

public class PublishedLottoDto {

    private final int lottoCount;
    private final List<Lotto> lottos;
    private final List<List<Integer>> lottoNumbers;

    public PublishedLottoDto(PublishedLotto publishedLotto) {
        this.lottoCount = publishedLotto.getLottoCount();
        convertToInts(publishedLotto);
        this.lottos = publishedLotto.getLottos();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void convertToInts(PublishedLotto publishedLotto) {
        publishedLotto.getLottos().stream()
                .map(Lotto::get)
    }
}
