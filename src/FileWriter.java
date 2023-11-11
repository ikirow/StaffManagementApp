import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;

public class FileWriter {
    public void saveDataToJSON(List<Employee> employees, String fileName) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(employees, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
