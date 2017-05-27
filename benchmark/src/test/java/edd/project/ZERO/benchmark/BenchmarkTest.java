package edd.project.ZERO.benchmark;

import edd.project.ZERO.algorithms.sort.GoldenSort;
import edd.project.ZERO.data.preparation.StupidArrayDataProvider;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class BenchmarkTest {

    private static BenchmarkRunner runner;

    @BeforeClass
    public static void init() {
        runner = new BenchmarkRunner();
    }

    @Setup(Level.Iteration)
    public void setupPrepare(BenchmarkUnit unit) {
        unit.forIteration(new GoldenSort(), new StupidArrayDataProvider().get(1000));
    }

    @Test
    public void testJavaArraysSortBenchmark() throws RunnerException {
        BenchmarkOpts opts = BenchmarkOpts.builder()
                .warmupIterations(1)
                .measurementIterations(1)
                .forks(1)
                .timeUnit(TimeUnit.MILLISECONDS)
                .className(getClass().getSimpleName())
                .methodName("benchmarkTest")
                .build();

        runner.runBenchmark(opts);

        // TODO analyze & print result
    }

    @Benchmark
    public void benchmarkTest(BenchmarkUnit unit) {
        unit.getAlgorithm().sort(unit.getData());
    }
}