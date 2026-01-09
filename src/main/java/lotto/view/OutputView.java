package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.PublishedLotto;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PRINT_PUBLISHED_LOTTO_NOTICE = "%d개를 구매했습니다.%n";

    public void printPublishedLotto(PublishedLotto publishedLotto) {
        int count = publishedLotto.count();
        System.out.printf(PRINT_PUBLISHED_LOTTO_NOTICE, count);
        for (Lotto lotto : publishedLotto.getLottos()) {
            System.out.println(
                    lotto.getNumbers().stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"))
            );
        }
    }
}
