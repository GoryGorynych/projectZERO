package edd.project.ZERO.benchmark;

import edd.project.ZERO.algorithms.sort.SortAlgorithm;
import edd.project.ZERO.data.preparation.DataProvider;
import lombok.Getter;

public class BenchmarkUnit<T> {

    @Getter
    private T data;

    private DataProvider<T> dataProvider;
    private SortAlgorithm<T> algorithm;
    private int dataLength;

    public BenchmarkUnit(DataProvider<T> dataProvider,
                     SortAlgorithm<T> algorithm,
                     int dataLength) {
        this.dataProvider = dataProvider;
        this.algorithm = algorithm;
        this.dataLength = dataLength;
    }

    public void init() {
        data = dataProvider.get(dataLength);
    }

    public void unitTest() {
        algorithm.sort(data);
    }
}
