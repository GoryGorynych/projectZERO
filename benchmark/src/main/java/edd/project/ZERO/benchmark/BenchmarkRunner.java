package edd.project.ZERO.benchmark;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.WarmupMode;

import java.util.Collection;

public class BenchmarkRunner {

    @AllArgsConstructor
    private enum Default {

        WARMUP_ITERATIONS(10),
        ITERATIONS(10),
        FORKS(1);

        @Getter
        private final int val;
    }

    public RunResult runBenchmark(Class clazz, String method) throws RunnerException {
        return runBenchmark(clazz, method,
                Default.WARMUP_ITERATIONS.getVal(),
                Default.ITERATIONS.getVal(),
                Default.FORKS.getVal());
    }

    public RunResult runBenchmark(Class clazz,
                                  String method,
                                  int warmupIterations,
                                  int measurementIterations,
                                  int forks) throws RunnerException {
        return makeRunner(clazz, method, warmupIterations, measurementIterations, forks).runSingle();
    }

    public Collection<RunResult> runBenchmarks(Class clazz) throws RunnerException {
        return runBenchmarks(clazz,
                Default.WARMUP_ITERATIONS.getVal(),
                Default.ITERATIONS.getVal(),
                Default.FORKS.getVal());
    }

    public Collection<RunResult> runBenchmarks(Class clazz,
                                              int warmupIterations,
                                              int measurementIterations,
                                              int forks) throws RunnerException {
        return makeRunner(clazz, null, warmupIterations, measurementIterations, forks).run();
    }

    private Runner makeRunner(Class clazz,
                              String method,
                              int warmupIterations,
                              int measurementIterations,
                              int forks) {
        return new Runner(new OptionsBuilder()
                .warmupMode(WarmupMode.BULK)
                .warmupIterations(warmupIterations)
                .measurementIterations(measurementIterations)
                .forks(forks)
                .includeWarmup(regexp(clazz.getSimpleName(), method))
                .include(regexp(clazz.getSimpleName(), method))
                .build());
    }

    private String regexp(String className, String methodName) {
        if (methodName == null) {
            return String.format("^.*%s.*$", className);
        }
        return String.format("^.*%s.*%s$", className, methodName);
    }
}
