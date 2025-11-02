package lotto.hadler;

import java.util.function.Supplier;

public class TestExceptionHandlerImpl implements ExceptionHandler{

    private static TestExceptionHandlerImpl instance;

    private TestExceptionHandlerImpl() {
    }

    public static TestExceptionHandlerImpl getInstance() {
        if (instance == null) {
            instance = new TestExceptionHandlerImpl();
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
                throw e;
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
                throw e;
            }
        }
    }
}
