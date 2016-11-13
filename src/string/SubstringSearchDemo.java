package string;

/**
 * demo substring search
 */
public class SubstringSearchDemo {
    public static void main(final String... args) {
        final AbstractSearchStringAlgorithm kmp = new KMP();
        trySearch(kmp, "abxabcabcaby", "abcaby");
        trySearch(kmp, "abcdasraabsabaaag", "aabs");

    }

    private static void trySearch(final AbstractSearchStringAlgorithm algorithm, final String text, final String word) {
        System.out.printf("Index of '%s' in '%s' is %s \n", word, text, algorithm.search(text, word));
    }
}
