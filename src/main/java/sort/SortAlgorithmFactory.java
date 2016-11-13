package sort;

import java.util.HashMap;

public class SortAlgorithmFactory {
    private static final HashMap<String, AbstractSortAlgorithm> sorts = new HashMap<>();
    private static final HashMap<String, Class<? extends AbstractSortAlgorithm>> classMapping = new HashMap<String, Class<? extends AbstractSortAlgorithm>>();
    private static AbstractSortAlgorithm defaultSort = new QuickSort();

    static {
        try {
            Class.forName("sort.BubbleSort");
            Class.forName("sort.InsertionSort");
            Class.forName("sort.MergeSort");
            Class.forName("sort.QuickSort");
            Class.forName("sort.PyramidSort");
        } catch (final ClassNotFoundException e) {
        }
    }

    public static AbstractSortAlgorithm getDefaultSort() {
        if (defaultSort == null) {
            defaultSort = getSort("quicksort");
        }
        return defaultSort;
    }

    public static AbstractSortAlgorithm getSort(final String name) {
        AbstractSortAlgorithm sort = sorts.get(name);
        if (sort != null) {
            final Class<? extends AbstractSortAlgorithm> c = classMapping.get(name);
            if (c != null) {
                try {
                    sort = c.newInstance();
                    sorts.put(name, sort);
                    return sort;
                } catch (final Exception e) {
                    System.err.println(e.getStackTrace());
                }

            }
        }
        return getDefaultSort();

    }

    public static void registerSort(final String name, final Class<? extends AbstractSortAlgorithm> sort) {
        classMapping.put(name, sort);
    }
}
