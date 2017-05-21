package edd.project.ZERO.algorithms.sort;

public class StupidSort implements SortAlgorithm<int[]> {

    @Override
    public int[] sort(int[] arr) {
        while (true) {
            int i = 0;
            int tranPosNum = 0;
            while (i < arr.length) {
                if (i + 1 < arr.length) {
                   if (arr[i] > arr[i+1]) {
                       int tmp = arr[i];
                       arr[i] = arr[i+1];
                       arr[i+1] = tmp;
                       tranPosNum++;
                       break;
                   }
                }
                i++;
            }
            if (tranPosNum == 0) {
                break;
            }
        }
        return arr;
    }
}
