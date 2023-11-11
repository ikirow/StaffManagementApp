import java.util.List;

public class StaffManager {
    private StaffService service;

    public StaffManager(StaffService service) {
        this.service = service;
    }

    public void execute(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
            case "Add":
                if (parts.length >= 6) {
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String department = parts[3];
                    String role = parts[4];
                    double salary = Double.parseDouble(parts[5]);
                    Employee employee = new Employee(id, name, department, role, salary);
                    service.addEmployee(employee);
                } else {
                    System.out.println("Invalid Add command. Correct format: Add [ID] [Name] [Department] [Role] [Salary]");
                }
                break;
            case "Edit":
                if (parts.length >= 6) {
                    int idToEdit = Integer.parseInt(parts[1]);
                    String newName = parts[2];
                    String newDepartment = parts[3];
                    String newRole = parts[4];
                    double newSalary = Double.parseDouble(parts[5]);
                    Employee updatedEmployee = new Employee(idToEdit, newName, newDepartment, newRole, newSalary);
                    service.editEmployee(idToEdit, updatedEmployee);
                } else {
                    System.out.println("Invalid Edit command. Correct format: Edit [ID] [NewName] [NewDepartment] [NewRole] [NewSalary]");
                }
                break;
            case "Fire":
                if (parts.length == 2) {
                    int idToFire = Integer.parseInt(parts[1]);
                    service.fireEmployee(idToFire);
                } else {
                    System.out.println("Invalid Fire command. Correct format: Fire [ID]");
                }
                break;
            case "List":
                if (parts.length == 2 && parts[1].equals("Employees")) {
                    service.listEmployees();
                } else {
                    System.out.println("Invalid List command. Correct format: List Employees");
                }
                break;
            case "Search":
                if (parts.length >= 3) {
                    String searchBy = parts[1];
                    String searchValue = parts[2];
                    List<Employee> searchResults = null;

                    if ("ID".equalsIgnoreCase(searchBy)) { // Use "ID" instead of "Id"
                        int searchId = Integer.parseInt(searchValue);
                        searchResults = service.searchEmployeesById(searchId);
                    } else if ("Name".equalsIgnoreCase(searchBy)) {
                        searchResults = service.searchEmployeesByName(searchValue);
                    } else if ("Department".equalsIgnoreCase(searchBy)) {
                        searchResults = service.searchEmployeesByDepartment(searchValue); // Use "searchEmployeesByDepartment"
                    } else {
                        System.out.println("Invalid Search command. Available options: ID, Name, Department");
                    }

                    if (searchResults != null) {
                        for (Employee result : searchResults) {
                            System.out.println(result);
                        }
                    } else {
                        System.out.println("No employee with that ID was found");
                    }
                } else {
                    System.out.println("Invalid Search command. Correct format: Search [ID/Name/Department] [Value]");
                }
                break;

            default:
                System.out.println("Invalid command.");
        }
    }
}
