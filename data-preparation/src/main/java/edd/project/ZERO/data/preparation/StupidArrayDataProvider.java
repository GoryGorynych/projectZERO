package edd.project.ZERO.data.preparation;

import java.util.Random;

public class StupidArrayDataProvider implements DataProvider<int[]> {

    private final Random rand;

    public StupidArrayDataProvider() {
        rand = new Random();
    }

    @Override
    public int[] get(int length) {
        int max = length * 2  + 1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }
}
