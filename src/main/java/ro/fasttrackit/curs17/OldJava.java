package ro.fasttrackit.curs17;

public class OldJava {
    public static void main(String[] args) {
        System.out.println(transformString("abC", new ToUppercaseTransformer()));
        System.out.println(transformString("abC", new ToLowercaseTransformer()));
        System.out.println(transformString("abC", new StringTransformer() {
            @Override
            public String transform(String word) {
                return "*".repeat(word.length());
            }
        }));
    }

    private static String transformString(String word, StringTransformer transformer) {
        return transformer.transform(word);
    }

}

interface StringTransformer {
    String transform(String word);
}

class ToUppercaseTransformer implements StringTransformer {

    @Override
    public String transform(String word) {
        return word.toUpperCase();
    }
}

class ToLowercaseTransformer implements StringTransformer {

    @Override
    public String transform(String word) {
        return word.toLowerCase();
    }
}
