package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.model.IssuedLotto;

public class OutputView {

    private static final String ISSUED_RESULT_FORMAT = "%d개를 구매했습니다.";

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
}
