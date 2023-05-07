package p1.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Optimizes the {@link HybridSort} by trying to find the k-value with the lowest number of read and write operations..
 */
public class    HybridOptimizer {

    /**
     * Optimizes the {@link HybridSort} by trying to find the k-value with the lowest number of read and write operations.
     * The method will try all possible values for k starting from 0 and return the k-value with the lowest number of read and write operations.
     * It will stop once if found the first local minimum or reaches the maximum possible k-value for the size of the given array.
     *
     * @param hybridSort the {@link HybridSort} to optimize.
     * @param array the array to sort.
     * @return the k-value with the lowest number of read and write operations.
     * @param <T> the type of the elements to be sorted.
     */
    public static <T> int optimize(HybridSort<T> hybridSort, T[] array) {
        ArraySortList<T> arraySortList = new ArraySortList<>(array);
        int minOperations = array.length ^2 + 1;
        int bestK = -1;
        for(int i=0;i<array.length;i++){
            hybridSort.setK(i);
            int currentOperations = arraySortList.getReadCount() + arraySortList.getWriteCount();
            if(currentOperations < minOperations){
                minOperations = currentOperations;
                bestK = hybridSort.getK();
            }
        }
        return bestK;
    }

}
