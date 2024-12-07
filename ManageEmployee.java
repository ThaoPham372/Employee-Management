import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ManageEmployee {
    static List<Employee> employeeList = new ArrayList<Employee>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("----- Employee Management System -----");
            System.out.println("1. Add employee.");
            System.out.println("2. Search employee by Name.");
            System.out.println("3. Show information employee.");
            System.out.println("4. Delete employee by Id.");
            System.out.println("5. Calculate Total Salary..");
            System.out.println("6. Exit.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployeeByName();
                    break;
                case 3:
                    showEmployees();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    calculateTotalSalary();
                    break;
                case 6:
                    System.out.println("Exit program!");
                    break;
                default :
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 6);
    }
public static void addEmployee() {
    System.out.print("Enter employee ID: ");
    String employeeId = scanner.nextLine();
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(employeeId)) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }
    System.out.print("Enter employee Name: ");
    String employeeName = scanner.nextLine();
    System.out.print("Enter employee Position: ");
    String position = scanner.nextLine();
    System.out.print("Enter employee Salary: ");
    double salary = scanner.nextDouble();

    Employee newEmployee = new Employee(employeeId, employeeName, position, salary);
    employeeList.add(newEmployee);
    System.out.println("New employee added successfully!");
}
public static void searchEmployeeByName() {
        System.out.print("Enter employee Name to search: ");
        String employeeNameToSearch = scanner.nextLine();
        boolean isfound = false;

        for (Employee employee : employeeList) {
            if(employee.getEmployeeName().equals(employeeNameToSearch)) {
                System.out.println ("Employee " + employee.getEmployeeName() +" is in list.");
                isfound = true;
                break;
            }
        }
        if (!isfound) {
            System.out.println("Employee not found!");
        }
}
public static void showEmployees(){
        if (employeeList.isEmpty()) {
            System.out.println("There are no employees.");
        }
        else {
            for (Employee employee : employeeList) {
                System.out.println("Information of Employee");
                System.out.println("------------------------");
                System.out.println("Employee ID: " + employee.getEmployeeId());
                System.out.println("Employee Name: " + employee.getEmployeeName());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Salary: " + employee.getSalary());
            }
        }
}
public static void deleteEmployee(){
        System.out.print("Enter employee ID to delete: ");
        String employeeId = scanner.nextLine();
        boolean isFound = false;

        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employeeList.remove(employee);
                System.out.println ("Employee deleted successfully!");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Employee not found!");
        }
}
public static void calculateTotalSalary(){
        double totalSalary = 0;

        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }
        System.out.println("Total salary of all employees: " + totalSalary);
}
}
