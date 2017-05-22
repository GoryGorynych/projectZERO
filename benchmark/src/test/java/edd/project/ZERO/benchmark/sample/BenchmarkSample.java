package edd.project.ZERO.benchmark.sample;

import edd.project.ZERO.data.preparation.ArrayDataProvider;
import org.openjdk.jmh.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class BenchmarkSample {

    private static final Logger log = LoggerFactory.getLogger(BenchmarkSample.class);

    public int[] arr10;
    public int[] arr50;
    public int[] arr100;
    public int[] arr500;
    public int[] arr1000;
    public int[] arr5000;
    public int[] arr10000;
    public int[] arr50000;
    public int[] arr100000;
    public int[] arr500000;

    @Setup(Level.Iteration)
    public void setup() {
        ArrayDataProvider dataPr = new ArrayDataProvider();
        arr10 = dataPr.get(10);
        arr50 = dataPr.get(50);
        arr100 = dataPr.get(100);
        arr500 = dataPr.get(500);
        arr1000 = dataPr.get(1000);
        arr5000 = dataPr.get(5000);
        arr10000 = dataPr.get(10000);
        arr50000 = dataPr.get(50000);
        arr100000 = dataPr.get(100000);
        arr500000 = dataPr.get(500000);
    }

    @Benchmark
    public void test10() {
        Arrays.sort(arr10);
    }

    @Benchmark
    public void test50() {
        Arrays.sort(arr50);
    }

    @Benchmark
    public void test100() {
        Arrays.sort(arr100);
    }

    @Benchmark
    public void test500() {
        Arrays.sort(arr500);
    }

    @Benchmark
    public void test1000() {
        Arrays.sort(arr1000);
    }

    @Benchmark
    public void test5000() {
        Arrays.sort(arr5000);
    }

    @Benchmark
    public void test10000() {
        Arrays.sort(arr10000);
    }

    @Benchmark
    public void test50000() {
        Arrays.sort(arr50000);
    }

    @Benchmark
    public void test100000() {
        Arrays.sort(arr100000);
    }

    @Benchmark
    public void test500000() {
        Arrays.sort(arr500000);
    }
}