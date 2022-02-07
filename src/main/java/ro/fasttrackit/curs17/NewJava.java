package ro.fasttrackit.curs17;

import java.util.function.Function;

public class NewJava {
    public static void main(String[] args) {
        System.out.println(transformString("Salut", word -> word.toUpperCase()));
        System.out.println(transformString("Salut", name -> name.toLowerCase()));
        System.out.println(transformString("Salut", address -> "*".repeat(address.length())));
        System.out.println(transformString("Salut", address -> new Person("Ana").name()));
        System.out.println(transformString("Salut", address -> {
            Person person = new Person("Ana");
            return transformString(person.name(), name -> name.toUpperCase());
        }));
    }

    private static String transformString(String word, Function<String, String> transformer) {
        return transformer.apply(word);
    }
}

record Person(String name) {
}