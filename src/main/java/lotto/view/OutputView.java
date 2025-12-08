package lotto.view;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.model.IssuedLotto;
import lotto.model.WinningGrade;

public class OutputView {

    private static final String ISSUED_RESULT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_RESULT_TITLE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printIssuedResult(IssuedLotto issuedLotto) {
        System.out.printf(ISSUED_RESULT_FORMAT, issuedLotto.getCount());
        System.out.println();
        List<Lotto> issuedLottos = issuedLotto.getLottos();
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : issuedLottos) {
            sb.append(
                    lotto.getNumbers().stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"))
            ).append("\n");
        }
        System.out.println(sb);
    }

    public void printWinningResult(EnumMap<WinningGrade, Integer> result, double rateOfReturn) {
        System.out.println(WINNING_RESULT_TITLE);
        for (WinningGrade winningGrade : result.keySet()) {
            System.out.println(winningGrade.getMatchCount() + "개 일치 (" + winningGrade.getPrize() + ") - " + result.get(
                    winningGrade) + "개");
        }
        System.out.printf(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }
}
