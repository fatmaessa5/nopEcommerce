package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class TestDataReader {
    private static Map<String, String> testData;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            testData = mapper.readValue(
                    TestDataReader.class.getClassLoader().getResourceAsStream("testdata.json"),
                    Map.class
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return testData.get(key);
    }
}
