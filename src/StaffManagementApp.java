import java.util.Scanner;
public class StaffManagementApp implements GlobalVariables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// implement fileReader/fileWriter to handle saving into csv/json
        FileReader reader = new FileReader();
        FileWriter writer = new FileWriter();
        StaffService service = new StaffService(reader, writer);
        StaffManager manager = new StaffManager(service);

        service.initializeFromJSON(jsonFilePath);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        boolean isRunning = true;
        while (isRunning) {
            String command = scanner.nextLine(); // Read user input
            if (command.equalsIgnoreCase("Save & Exit")) {
                isRunning = false;
            } else {
                manager.execute(command);
            }
        }
    }
    private static void displayCommands() {
        System.out.println("Available commands:");
        System.out.println("Add Employee");
        System.out.println("Edit ID");
        System.out.println("Fire ID");
        System.out.println("List Employees");
        System.out.println("Search Department");
        System.out.println("Search ID");
        System.out.println("Search Name");
        System.out.println("Save & Exit");
    }
}