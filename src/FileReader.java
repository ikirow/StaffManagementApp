import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> readDataFromJSON(String fileName) {
        try (java.io.FileReader reader = new java.io.FileReader(fileName)) {
            Gson gson = new Gson();
            Employee[] employeeArray = gson.fromJson(reader, Employee[].class);
            employees.clear();
            employees.addAll(Arrays.asList(employeeArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
