package sort;

public abstract class Sort {
    public abstract <T extends Comparable> Iterable<T> doSort(Iterable<T> data);
}
