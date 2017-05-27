package edd.project.ZERO.benchmark;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.WarmupMode;

import java.util.Collection;

public class BenchmarkRunner {

    public RunResult runBenchmark(BenchmarkOpts benchmarkOpts) throws RunnerException {
        return makeRunner(benchmarkOpts).runSingle();
    }

    public Collection<RunResult> runBenchmarks(BenchmarkOpts benchmarkOpts) throws RunnerException {
        return makeRunner(benchmarkOpts).run();
    }

    private Runner makeRunner(BenchmarkOpts benchmarkOpts) {
        return new Runner( new OptionsBuilder()
                .warmupIterations(benchmarkOpts.getWarmupIterations())
                .measurementIterations(benchmarkOpts.getMeasurementIterations())
                .forks(benchmarkOpts.getForks())
                .timeUnit(benchmarkOpts.getTimeUnit())
                .includeWarmup(regexp(benchmarkOpts.getClassName(), benchmarkOpts.getMethodName()))
                .include(regexp(benchmarkOpts.getClassName(), benchmarkOpts.getMethodName()))
                .mode(Mode.AverageTime)
                .warmupMode(WarmupMode.BULK)
                .build());
    }

    private String regexp(String className, String methodName) {
        if (methodName == null) {
            return String.format("^.*%s.*$", className);
        }
        return String.format("^.*%s.*%s$", className, methodName);
    }
}
