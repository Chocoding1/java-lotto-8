package lotto.model.dto;

import java.util.List;
import lotto.model.Lotto;

public class PublishedLottoDto {

    private final int lottoCount;
    private final List<Lotto> lottos;

    private PublishedLottoDto(int lottoCount, List<Lotto> lottos) {
        this.lottoCount = lottoCount;
        this.lottos = lottos;
    }

    public static PublishedLottoDto of(int lottoCount, List<Lotto> lottos) {
        return new PublishedLottoDto(lottoCount, lottos);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
