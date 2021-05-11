package com.lesson3.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


/**
 * class for manipulate with items array in FixPriceShop and Contractor
 */
public class StorageUtil {

    /**
     * @param target String array with items for remove null and empty string values
     * @return filtered array
     */
    static String[] validateList(String[] target) {
        List<String> filtered = new ArrayList<>(Arrays.asList(target));
        filtered.removeIf(elem -> elem == null || elem.replaceAll(" ", "").equals(""));
        return filtered.toArray(new String[0]);
    }

    /** Method for filter items (when cunsomer buys somthing or contractor supply items)
     * @param target String array for filtering
     * @param items items to remove from target array
     * @return filtered array
     */
    static String[] filterStorage(String[] target, String[] items) {
        List<String> filtered = new ArrayList<>(Arrays.asList(target));
        filtered.removeIf(elem -> new ArrayList<>(Arrays.asList(items)).contains(elem));
        return filtered.toArray(new String[0]);
    }

    /** Method for filter items (when cunsomer buy somthing or contractor supply items)
     * @param target String array for filtering
     * @param item item to remove from target array
     * @return filtered array
     */
    static String[] filterStorage(String[] target, String item) {
        List<String> filtered = new ArrayList<>(Arrays.asList(target));
        filtered.removeIf(elem -> elem.equals(item));
        return filtered.toArray(new String[0]);
    }
    public static boolean contains(String[] arr, String value) {

        return Arrays.asList(arr).contains(value);
    }
}
