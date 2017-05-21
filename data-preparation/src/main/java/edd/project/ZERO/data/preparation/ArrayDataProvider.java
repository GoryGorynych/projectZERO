package edd.project.ZERO.data.preparation;

import java.util.Random;

public class ArrayDataProvider implements DataProvider<int[]> {

    private final Random rand;

    public ArrayDataProvider() {
        rand = new Random();
    }

    @Override
    public int[] get(int[] arr) {
        int min = 0;
        int max = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    @Override
    public int[] get(int length) {
        return get(new int[length]);
    }
}
