package edd.project.ZERO.graphics.read.jmh;

import edd.project.ZERO.graphics.read.BenchmarkReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JmhBenchmarkSimpleReader implements BenchmarkReader {

    private static final Logger log = LoggerFactory.getLogger(JmhBenchmarkSimpleReader.class);

    @Override
    public Map<String, Double> read(InputStream in) {
        if (in == null) {
            log.error("InputStream must not be null");
            throw new IllegalArgumentException("InputStream must not be null");
        }
        return extractMeasurements(readStream(in));
    }

    private String readStream(InputStream in) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.debug("Read line: {}", line);
                result.append(line);
            }
        } catch (IOException e) {
            log.error("Can't read InputStream", e);
            throw new RuntimeException("Can't read InputStream", e);
        }
        return result.toString();
    }

    private Map<String, Double> extractMeasurements(String result) {
        Map<String, Double> measurements = new HashMap<>();
        measurements.put(result, 0.0);
        // TODO
        return measurements;
    }
}
