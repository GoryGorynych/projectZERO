package edd.project.ZERO.algorithms.sort;

import java.util.Arrays;

public class GoldenSort implements SortAlgorithm<int[]> {

    @Override
    public int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
