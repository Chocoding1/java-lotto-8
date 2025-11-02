package lotto.hadler;

import java.util.function.Supplier;

public interface ExceptionHandler {

    <T> T trySupplierUntilSuccess(Supplier<T> supplier);

    void tryRunnableUntilSuccess(Runnable runnable);
}
