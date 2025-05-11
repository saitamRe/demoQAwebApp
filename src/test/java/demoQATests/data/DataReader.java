package demoQATests.data;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataReader {
    public String getDataFromJson() throws IOException {
        File file = new File(System.getProperty("user.dir"+"src/test/java/data/PurchaseOrder.json"));
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
