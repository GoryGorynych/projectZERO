package edd.project.ZERO.benchmark;

import edd.project.ZERO.algorithms.sort.GoldenSort;
import edd.project.ZERO.data.preparation.ArrayDataProvider;
import edd.project.ZERO.data.preparation.DataProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openjdk.jmh.runner.RunnerException;

public class BenchmarkTest {

    private static BenchmarkRunner runner;
    private static DataProvider<int[]> dataProvider;

    private BenchmarkUnit<int[]> unit;

    @BeforeClass
    public static void init() {
        runner = new BenchmarkRunner();
        dataProvider = new ArrayDataProvider();
    }

    @Before
    public void setup() {
        unit = new BenchmarkUnit<>(dataProvider, new GoldenSort(), 1000);
    }

    @Test
    public void testJavaArraysSortBenchmark() throws RunnerException {
        runner.runBenchmark(unit.getClass().getSimpleName(), "unitTest", 1, 1, 1);

        // TODO analyze & print result
    }
}
