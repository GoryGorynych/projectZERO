package edd.project.ZERO.benchmark;

import edd.project.ZERO.benchmark.algorithms.JavaArraysSortBenchmark;
import org.openjdk.jmh.runner.RunnerException;

public class Main {

    private static final BenchmarkRunner runner = new BenchmarkRunner();

    public static void main(String... args) throws RunnerException {
        runner.runBenchmarks(JavaArraysSortBenchmark.class);

        // TODO analyze & print result
    }
}
