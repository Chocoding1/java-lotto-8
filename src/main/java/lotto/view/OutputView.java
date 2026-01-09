package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.PublishedLotto;
import lotto.model.WinningGrade;
import lotto.model.WinningResult;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PRINT_PUBLISHED_LOTTO_FORMAT = "%d개를 구매했습니다.%n";
    private static final String PRINT_WINNING_RESULT_TITLE = "당첨 통계" + LINE_SEPARATOR + "---";
    private static final String PRINT_WINNING_GRADE_FORMAT = "%s (%s원) - %d개%n";
    private static final String PRINT_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.%n";

    public void printPublishedLotto(PublishedLotto publishedLotto) {
        int count = publishedLotto.count();
        System.out.printf(PRINT_PUBLISHED_LOTTO_FORMAT, count);
        for (Lotto lotto : publishedLotto.getLottos()) {
            System.out.println(
                    lotto.getNumbers().stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"))
            );
        }
    }

    public void printWinningResult(WinningResult winningResult, double rateOfReturn) {
        System.out.println(PRINT_WINNING_RESULT_TITLE);
        DecimalFormat df = new DecimalFormat("#,###");
        for (WinningGrade winningGrade : WinningGrade.values()) {
            if (winningGrade.equals(WinningGrade.NONE)) {
                continue;
            }
            System.out.printf(PRINT_WINNING_GRADE_FORMAT, winningGrade.getPrintFormat(), df.format(winningGrade.getPrize()), winningResult.getMatchCount(winningGrade));
        }
        System.out.printf(PRINT_RATE_OF_RETURN_FORMAT, rateOfReturn);
    }
}
