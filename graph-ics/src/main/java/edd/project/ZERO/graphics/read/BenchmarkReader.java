package edd.project.ZERO.graphics.read;

import java.io.InputStream;
import java.util.Map;

public interface BenchmarkReader {

    Map<String, Double> read(InputStream in);
}
