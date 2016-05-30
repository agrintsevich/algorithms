package util;

import sort.QuickSort;
import sort.Sort;

import java.util.HashMap;

public class SortAlgorithmFactory {
    private static HashMap<String, Sort> sorts = new HashMap<>();
    private static HashMap<String, Class<? extends Sort>> classMapping = new HashMap<String, Class<? extends Sort>>();
    private static Sort defaultSort = new QuickSort();

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

    public static Sort getDefaultSort() {
        if (defaultSort == null) {
            defaultSort = getSort("quicksort");
        }
        return defaultSort;
    }

    public static Sort getSort(String name) {
        Sort sort = sorts.get(name);
        if (sort != null) {
            Class<? extends Sort> c = classMapping.get(name);
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

    public static void registerSort(String name, Class<? extends Sort> sort) {
        classMapping.put(name, sort);
    }
}
