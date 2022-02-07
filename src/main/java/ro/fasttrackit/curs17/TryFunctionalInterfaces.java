package ro.fasttrackit.curs17;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TryFunctionalInterfaces {
    public static void main(String[] args) {
        tryFunction(a -> a + 1);
        tryFunction(b -> b * 10);

        trySupplier(() -> "Hello");
        trySupplier(() -> "World");

        tryPredicate(input -> input.length() > 2);
        tryPredicate(input -> input.length() > 20);

        tryConsumer(input -> System.out.println(input + " consumed"));
        tryConsumer(input -> System.out.println(input + " consumed again!"));
        tryConsumer(input -> {
            int a = input.length();
        });

        tryRunnable(() -> {
            System.out.println("Fac ce vreau cu viata mea!");
        });
        tryRunnable(() -> {
        });

        tryMultiple(
                () -> "Ana",
                str -> str.length(),
                number -> number > 5,
                number -> System.out.println("Este mai mare decat 5"),
                () -> System.out.println("Nu este mai mare decat 5"));
    }

    private static void tryMultiple(
            Supplier<String> supplier,
            Function<String, Integer> transformer,
            Predicate<Integer> tester,
            Consumer<Integer> intConsumer,
            Runnable runnable) {
        Integer value = transformer.apply(supplier.get());
        if (tester.test(value)) {
            intConsumer.accept(value);
        } else {
            runnable.run();
        }
    }

    private static void tryRunnable(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("A fost o eroare!");
        }
    }

    private static void tryConsumer(Consumer<String> stringConsumer) {
        stringConsumer.accept("ceva");
        stringConsumer.accept("food");
        stringConsumer.accept("candy");
    }

    public static void tryPredicate(Predicate<String> stringTester) {
        if (stringTester.test("Hello world")) {
            System.out.println("A trecut testul");
        } else {
            System.out.println("Nu a trecut testul");
        }
    }

    public static void trySupplier(Supplier<String> stringSupplier) {
        String value = stringSupplier.get();
        if (value.startsWith("H")) {
            System.out.println(value.toUpperCase());
        } else {
            System.out.println("Not H");
        }
    }

    public static void tryFunction(Function<Integer, Integer> incrementor) {
        System.out.println(incrementor.apply(3));
        System.out.println(incrementor.apply(13));
    }
}
