package edd.project.ZERO.data.preparation;

import java.util.Random;

public class ArrayDataProvider implements DataProvider<int[]> {

    private final Random rand;

    public ArrayDataProvider() {
        rand = new Random();
    }

    @Override
    public int[] get(int length) {
        int min = 0;
        int max = length * 2;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }
}
