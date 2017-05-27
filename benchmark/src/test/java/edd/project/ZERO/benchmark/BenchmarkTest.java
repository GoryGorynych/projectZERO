package edd.project.ZERO.benchmark;

import edd.project.ZERO.algorithms.sort.GoldenSort;
import edd.project.ZERO.data.preparation.StupidArrayDataProvider;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
public class BenchmarkTest {

    private static BenchmarkRunner runner;

    @BeforeClass
    public static void init() {
        runner = new BenchmarkRunner();
    }

    @Setup(Level.Iteration)
    public void setupPrepare(BenchmarkUnit unit) {
        unit.init(new StupidArrayDataProvider(), new GoldenSort());
    }

    @Test
    public void testJavaArraysSortBenchmark() throws RunnerException {
        runner.runBenchmark(this.getClass().getSimpleName(), "benchmarkTest", 1, 1, 1);

        // TODO analyze & print result
    }

    @Benchmark
    public void benchmarkTest(BenchmarkUnit unit) {
        unit.getAlgorithm().sort(unit.prepareData(1000));
    }
}
