package mainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
	
	private List<Employee> employees;
    private Random random;
    private Scanner scanner;

	public MainApp() {
		employees = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
	}
	
	public void addEmployee() {
        String name;
        do {
            System.out.print("Enter employee name (minimum 3 characters): ");
            name = scanner.nextLine();
        } while (name.length() < 3);

        String gender;
        do {
            System.out.print("Enter employee gender ((0)Male (1)Female): ");
            gender = scanner.nextLine();
        } while (!gender.equals("0") && !gender.equals("1"));
        if (gender.equals("0")) {
        	gender = "Male";
        }
        if (gender.equals("1")) {
        	gender = "Female";
        }

        String title;
        double salary = 0;
        do {
            System.out.print("Enter employee title ((0)Manager (1)Supervisor (2)Admin): ");
            title = scanner.nextLine();
        } while (!title.equals("0") && !title.equals("1") && !title.equals("2"));
        if (title.equals("0")) {
        	title = "Manager";
            salary = 8000000.0;
        }
        if (title.equals("1")) {
			title = "Supervisor";
            salary = 6000000.0;
		}
        if (title.equals("2")) {
        	title = "Admin";
            salary = 4000000.0;
        }

        Employee employee = new Employee(name, gender, title, salary);
        employees.add(employee);
        System.out.println("Employee with code " + employee.getCode() + " added successfully!");
        System.out.print("Enter to continue");
        scanner.nextLine();
    }

    public void updateEmployee() {
    	viewEmployee();
        System.out.print("Enter employee code to update: ");
        String empCode = scanner.nextLine();
        Employee employee = findEmployee(empCode);
        if (employee != null) {
        	
            String name;
            do {
                System.out.print("Enter employee name (minimum 3 characters): ");
                name = scanner.nextLine();
            } while ((name.length() < 3) && !name.isEmpty());
            if (name.isEmpty()) {
            	employee.setName(name);
            }
            
            String gender;
            do {
                System.out.print("Enter employee gender ((0)Male (1)Female Press enter to keep unchanged): ");
                gender = scanner.nextLine();
            } while (!gender.equals("0") && !gender.equals("1") && !gender.isEmpty());
            if (gender.equals("0")) {
            	gender = "Male";
            }
            if (gender.equals("1")) {
            	gender = "Female";
            }
            if (gender.isEmpty()) {
            	employee.setGender(gender);
            }
            
            String title;
            double salary = 0;
            do {
                System.out.print("Enter employee title ((0)Manager (1)Supervisor (2)Admin Press enter to keep unchanged): ");
                title = scanner.nextLine();
            } while (!title.equals("0") && !title.equals("1") && !title.equals("2") && !title.isEmpty());
            if (title.equals("0")) {
            	title = "Manager";
                salary = 8000000.0;
            }
            if (title.equals("1")) {
    			title = "Supervisor";
                salary = 6000000.0;
    		}
            if (title.equals("2")) {
            	title = "Admin";
                salary = 4000000.0;
            }
            System.out.println("Employee with ID " + employee.getCode() + " updated successfully:");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            
        } else {
            System.out.println("Employee not found.");
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }
    }

    public void viewEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
            return;
        }

        System.out.println("Employees list:");
        printEmployeeTableHeader();
        int index = 1;
        for (Employee employee : employees) {
            printEmployeeTableRow(employee, index++);
        }
        System.out.println("------------------------------------------------------------------------------");
    }

    private void printEmployeeTableHeader() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-13s | %-15s | %-8s | %-9s | %-10s |\n", "No.", "Employee ID", "Employee Name", "Gender", "Title", "Salary");
        System.out.println("------------------------------------------------------------------------------");
    }

    private void printEmployeeTableRow(Employee employee, int index) {
        System.out.printf("| %-4d | %-13s | %-15s | %-8s | %-9s | %-10.2f |\n", index, employee.getCode(), employee.getName(), employee.getGender(), employee.getTitle(), employee.getSalary());
    }

    public void deleteEmployee(String empCode) {
        Employee employee = findEmployee(empCode);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee with code " + employee.getCode() + " deleted successfully!");
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        } else {
            System.out.println("Employee not found.");
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }
    }

    private Employee findEmployee(String empCode) {
        for (Employee employee : employees) {
            if (employee.getCode().equals(empCode)) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MainApp ems = new MainApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. View Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print(">> ");
            String choice = scanner.next();
            scanner.nextLine();

            if (choice.matches("[1-5]")) {
            	int choice2 = Integer.parseInt(choice);
            	switch (choice2) {
                	case 1:
                		ems.addEmployee();
                		break;
                	case 2:
                		ems.updateEmployee();
                		break;
                	case 3:
                		ems.viewEmployee();
                        System.out.print("Enter to continue");
                        scanner.nextLine();
                		break;
                	case 4:
                		ems.viewEmployee();
                		System.out.print("Enter employee code to delete: ");
                    	String deleteCode = scanner.nextLine();
                    	ems.deleteEmployee(deleteCode);
                    	break;
                	case 5:
                		System.out.println("Exiting...");
                		scanner.close();
                		System.exit(0);
                		break;
            	}
            } else {
            	System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            	System.out.print("Press Enter to continue...");
            	scanner.nextLine();
            }
        }
    }
}