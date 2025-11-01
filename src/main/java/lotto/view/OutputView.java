package lotto.view;

import java.util.List;
import lotto.model.CompareResult;
import lotto.model.Lotto;
import lotto.model.ResultForView;

public class OutputView {

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printPublishedResult(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

    }

    public void printWinningResult(ResultForView resultForView, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultForView.getThree() + "개");
        System.out.println("4개 일치 (50,000원) - " + resultForView.getFour() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultForView.getFive() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultForView.getBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultForView.getSix() + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
