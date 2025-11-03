package lotto.model.dto;

import java.util.List;
import lotto.model.domain.lotto.PublishedLotto;

public class PublishedLottoDto {

    private final int lottoCount;
    private final List<List<Integer>> lottoNumbers;

    public PublishedLottoDto(PublishedLotto publishedLotto) {
        this.lottoCount = publishedLotto.getLottoCount();
        this.lottoNumbers = publishedLotto.getLottoNumbers();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
