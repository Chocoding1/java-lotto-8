package lotto.model.dto;

import java.util.EnumMap;
import lotto.model.domain.LottoRank;

public class WinningResultDto {

    private final EnumMap<LottoRank, Integer> rankCountMap;

    public WinningResultDto(EnumMap<LottoRank, Integer> rankCountMap) {
        this.rankCountMap = rankCountMap;
    }

    public EnumMap<LottoRank, Integer> getRankCountMap() {
        return rankCountMap;
    }

}
