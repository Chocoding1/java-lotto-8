package lotto.hadler;

import java.util.function.Supplier;

public class ExceptionHandlerImpl implements ExceptionHandler {

    @Override
    public <T> T trySupplierUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void tryRunnableUntilSuccess(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
