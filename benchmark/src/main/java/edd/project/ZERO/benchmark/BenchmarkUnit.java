package edd.project.ZERO.benchmark;

import edd.project.ZERO.algorithms.sort.SortAlgorithm;
import edd.project.ZERO.data.preparation.DataProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@NoArgsConstructor
@State(Scope.Benchmark)
public class BenchmarkUnit<T> {

    @Getter
    private SortAlgorithm<T> algorithm;

    private DataProvider<T> dataProvider;

    public void init(DataProvider<T> dataProvider, SortAlgorithm<T> algorithm) {
        this.dataProvider = dataProvider;
        this.algorithm = algorithm;
    }

    public T prepareData(int dataLength) {
        return dataProvider.get(dataLength);
    }
}
