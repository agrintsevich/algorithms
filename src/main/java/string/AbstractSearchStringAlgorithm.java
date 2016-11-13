package string;

/**
 * abstract substring search algoritm
 */
public abstract class AbstractSearchStringAlgorithm {
    protected static final int NOT_FOUND = -1;

    abstract int search(final String text, final String word);
}
