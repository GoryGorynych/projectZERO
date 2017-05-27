package edd.project.ZERO.benchmark;

import edd.project.ZERO.algorithms.sort.SortAlgorithm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@NoArgsConstructor
@State(Scope.Benchmark)
public class BenchmarkUnit<T> {

    @Getter
    private SortAlgorithm<T> algorithm;

    @Getter
    private T data;

    public void forIteration(SortAlgorithm<T> algorithm, T data) {
        this.data = data;
        this.algorithm = algorithm;
    }
}