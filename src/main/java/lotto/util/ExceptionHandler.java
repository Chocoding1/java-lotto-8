package lotto.util;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T wrappingSupplier(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
