package lotto.util;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.model.WinningLotto;
import lotto.model.WinningLottoGenerator;

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

    public static WinningLotto wrappingGenerator(WinningLottoGenerator generator) {
        while (true) {
            try {
                return generator.generate();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
