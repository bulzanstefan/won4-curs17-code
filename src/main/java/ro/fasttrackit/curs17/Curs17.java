package ro.fasttrackit.curs17;

import java.util.function.Function;

public class Curs17 {
    public static void main(String[] args) {
        methodCallRef(String::length);
        methodCallRef(Integer::parseInt);
        methodCallRef(Curs17::len);
    }

    private static int len(String str) {
        return 1;
    }

    private static void methodCallRef(Function<String, Integer> str) {
        str.apply("abc");
    }
}
