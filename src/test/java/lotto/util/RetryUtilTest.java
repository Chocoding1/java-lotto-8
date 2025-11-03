package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryUtilTest {


    @Test
    @DisplayName("예외가 발생하지 않을 때까지 5번 반복 테스트")
    void tryReturnUntilSuccess_repeat_5_times() {
        // given
        AtomicInteger attempts = new AtomicInteger(0);

        // when
        Integer attemptsCount = RetryUtil.tryReturnUntilSuccess(() -> {
            if (attempts.get() < 5) {
                attempts.getAndIncrement();
                throw new IllegalArgumentException("[ERROR]");
            }
            return attempts.get();
        });

        // then
        Assertions.assertThat(attemptsCount).isEqualTo(5);
        Assertions.assertThat(attempts.get()).isEqualTo(5);
    }

    @Test
    @DisplayName("예외가 발생하지 않을 때까지 5번 반복 테스트")
    void tryRunUntilSuccess_repeat_5_times() {
        // given
        AtomicInteger attempts = new AtomicInteger(0);

        // when
        RetryUtil.tryRunUntilSuccess(() -> {
            if (attempts.get() < 5) {
                attempts.getAndIncrement();
                throw new IllegalArgumentException("[ERROR]");
            }
        });

        // then
        Assertions.assertThat(attempts.get()).isEqualTo(5);
    }
}