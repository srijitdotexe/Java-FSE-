import java.util.Scanner;

public class EmployeeManagementSystem {
    private static Employee[] employees = new Employee[10]; // Initial size of 10
    private static int employeeCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    searchEmployeeById(scanner);
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    deleteEmployeeById(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        if (employeeCount >= employees.length) {
            System.out.println("Employee list is full. Cannot add more employees.");
            return;
        }

        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        employees[employeeCount++] = new Employee(id, name, position, salary);
        System.out.println("Employee added successfully.");
    }

    private static void searchEmployeeById(Scanner scanner) {
        System.out.print("Enter employee ID to search: ");
        String id = scanner.nextLine();

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                System.out.println("Employee found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void traverseEmployees() {
        if (employeeCount == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("Employee List:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    private static void deleteEmployeeById(Scanner scanner) {
        System.out.print("Enter employee ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                // Shift elements left
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null; // Remove last reference
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
