package sort;

/**
 * abstract class for sort algorithms
 */
public abstract class AbstractSortAlgorithm {
    public abstract <T extends Comparable> Iterable<T> doSort(Iterable<T> data);
}
