package lotto.view;

import static lotto.model.domain.LottoRank.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.domain.LottoRank;
import lotto.model.dto.WinningResultDto;
import lotto.model.dto.PublishedLottoDto;

public final class OutputView {

    private static final String LOTTO_COUNT_VIEW_SUFFIX = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_SUBJECT = "당첨 통계";
    private static final String LINE_DELIMITER = "---";
    private static final String COMMA = ", ";
    private static final String LEFT_SQUARE_BRACKETS = "[";
    private static final String RIGHT_SQUARE_BRACKETS = "]";

    private OutputView() {
    }

    public static void printPublishedResult(PublishedLottoDto publishedLottoDto) {
        System.out.println(publishedLottoDto.getLottoCount() + LOTTO_COUNT_VIEW_SUFFIX);
        for (List<Integer> lottoNumber : publishedLottoDto.getLottoNumbers()) {
            System.out.println(convertForView(lottoNumber));
        }

    }

    public static void printWinningResult(WinningResultDto winningResultDto, double rateOfReturn) {
        EnumMap<LottoRank, Integer> rankCountMap = winningResultDto.getRankCountMap();
        System.out.println(LOTTO_RESULT_SUBJECT);
        System.out.println(LINE_DELIMITER);
        System.out.println("3개 일치 (5,000원) - " + rankCountMap.getOrDefault(FIFTH_RANK, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCountMap.getOrDefault(FOURTH_RANK, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCountMap.getOrDefault(THIRD_RANK, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCountMap.getOrDefault(SECOND_RANK, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCountMap.getOrDefault(FIRST_RANK, 0) + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    private static String convertForView(List<Integer> lottoNumber) {
        return lottoNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA, LEFT_SQUARE_BRACKETS, RIGHT_SQUARE_BRACKETS));
    }
}
