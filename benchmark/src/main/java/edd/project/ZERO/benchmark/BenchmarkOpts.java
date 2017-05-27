package edd.project.ZERO.benchmark;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BenchmarkOpts {

    private final int warmupIterations;
    private final int measurementIterations;
    private final int forks;
    private final TimeUnit timeUnit;
    private final String className;
    private final String methodName;
}
