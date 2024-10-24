import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Quản Lý Nhân Viên ===");
            System.out.println("1. Nhập nhân viên");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Chỉnh sửa nhân viên");
            System.out.println("4. Hiện danh sách nhân viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng còn lại

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ID nhân viên: ");
        int id = scanner.nextInt();
        employees.add(new Employee(name, id));
        System.out.println("Nhân viên đã được thêm thành công!");
    }

    private static void removeEmployee() {
        System.out.print("Nhập ID nhân viên muốn xóa: ");
        int id = scanner.nextInt();
        employees.removeIf(employee -> employee.getId() == id);
        System.out.println("Nhân viên đã được xóa (nếu tồn tại)!");
    }

    private static void editEmployee() {
        System.out.print("Nhập ID nhân viên muốn chỉnh sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Đọc dòng còn lại

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.print("Nhập tên mới: ");
                String newName = scanner.nextLine();
                employees.remove(employee);
                employees.add(new Employee(newName, id));
                System.out.println("Nhân viên đã được chỉnh sửa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên với ID này.");
    }

    private static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            System.out.println("Danh sách nhân viên:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
