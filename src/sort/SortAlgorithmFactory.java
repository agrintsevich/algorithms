package util;

import sort.QuickSort;
import sort.AbstractSortAlgorithm;

import java.util.HashMap;

public class SortAlgorithmFactory {
    private static HashMap<String, AbstractSortAlgorithm> sorts = new HashMap<>();
    private static HashMap<String, Class<? extends AbstractSortAlgorithm>> classMapping = new HashMap<String, Class<? extends AbstractSortAlgorithm>>();
    private static AbstractSortAlgorithm defaultSort = new QuickSort();

    static {
        try {
            Class.forName("sort.BubbleSort");
            Class.forName("sort.InsertionSort");
            Class.forName("sort.MergeSort");
            Class.forName("sort.QuickSort");
            Class.forName("sort.PyramidSort");
        } catch (ClassNotFoundException e) {
        }
    }

    public static AbstractSortAlgorithm getDefaultSort() {
        if (defaultSort == null) {
            defaultSort = getSort("quicksort");
        }
        return defaultSort;
    }

    public static AbstractSortAlgorithm getSort(String name) {
        AbstractSortAlgorithm sort = sorts.get(name);
        if (sort != null) {
            Class<? extends AbstractSortAlgorithm> c = classMapping.get(name);
            if (c != null) {
                try {
                    sort = c.newInstance();
                    sorts.put(name, sort);
                    return sort;
                } catch (Exception e) {
                    System.err.println(e.getStackTrace());
                }

            }
        }
        return getDefaultSort();

    }

    public static void registerSort(String name, Class<? extends AbstractSortAlgorithm> sort) {
        classMapping.put(name, sort);
    }
}
