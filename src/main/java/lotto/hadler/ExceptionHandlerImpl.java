package lotto.hadler;

import java.util.function.Supplier;

public class ExceptionHandlerImpl implements ExceptionHandler {

    private static ExceptionHandlerImpl instance;

    private ExceptionHandlerImpl() {
    }

    public static ExceptionHandlerImpl getInstance() {
        if (instance == null) {
            instance = new ExceptionHandlerImpl();
        }
        return instance;
    }

    @Override
    public <T> T trySupplierUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
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
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
