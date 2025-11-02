package lotto.view;

import java.util.Map;
import lotto.model.domain.Lotto;
import lotto.model.dto.ResultForView;
import lotto.model.dto.PublishedLottoDto;

public final class OutputView {

    private OutputView() {
    }

    public static void printPublishedResult(PublishedLottoDto publishedLottoDto) {
        System.out.println(publishedLottoDto.getLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : publishedLottoDto.getLottos()) {
            System.out.println(lotto);
        }

    }

    public static void printWinningResult(ResultForView resultForView, double rateOfReturn) {
        Map<Integer, Integer> result = resultForView.getResultCount();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultForView.getBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(6, 0) + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
