package edd.project.ZERO.benchmark.algorithms;

import edd.project.ZERO.algorithms.sort.SortAlgorithm;
import edd.project.ZERO.algorithms.sort.StupidSort;
import edd.project.ZERO.data.preparation.ArrayDataProvider;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@Fork(1)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class StupidSortBenchmark {

    public SortAlgorithm algorithm = new StupidSort();

    public int[] arr10;
    public int[] arr50;
    public int[] arr100;
    public int[] arr500;
    public int[] arr1000;
    public int[] arr5000;
    public int[] arr10000;

    @Setup(Level.Iteration)
    public void setup() {
        ArrayDataProvider dataPr = new ArrayDataProvider();
        arr10 = dataPr.get(new int[10]);
        arr50 = dataPr.get(new int[50]);
        arr100 = dataPr.get(new int[100]);
        arr500 = dataPr.get(new int[500]);
        arr1000 = dataPr.get(new int[1000]);
        arr5000 = dataPr.get(new int[5000]);
        arr10000 = dataPr.get(new int[10000]);
    }

    @Benchmark
    public void test10() {
        algorithm.sort(arr10);
    }

    @Benchmark
    public void test50() {
        algorithm.sort(arr50);
    }

    @Benchmark
    public void test100() {
        algorithm.sort(arr100);
    }

    @Benchmark
    public void test500() {
        algorithm.sort(arr500);
    }

    @Benchmark
    public void test1000() {
        algorithm.sort(arr1000);
    }

    @Benchmark
    public void test5000() {
        algorithm.sort(arr5000);
    }

    @Benchmark
    public void test10000() {
        algorithm.sort(arr10000);
    }
}