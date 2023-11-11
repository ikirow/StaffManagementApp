public class Employee {
    private int id;
    private String name;
    private String department;
    private String role;
    private double salary;
    private boolean isEmployed; // To track if the employee is currently employed

    public Employee(int id, String name, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.isEmployed = true; // Newly added employees are employed by default
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Department: " + department + "\n" +
                "Role: " + role + "\n" +
                "Salary: " + salary + "\n" +
                "Employed: " + (isEmployed ? "Yes" : "No");
    }
}
