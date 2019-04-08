package controller;

import entity.Employee;
import model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {

    private EmployeeModel employeeModel = new EmployeeModel();

    Scanner scanner = new Scanner(System.in);

    public void registerAccount() {
        while (true) {
            System.out.println("----Đăng ký tài khoản----");
            System.out.println("Vui lòng nhập tên: ");
            String name = scanner.nextLine();
            System.out.println("Vui lòng nhập địa chỉ: ");
            String address = scanner.nextLine();
            System.out.println("Vui lòng nhập email: ");
            String email = scanner.nextLine();
            System.out.println("Vui lòng nhập tên tài khoản: ");
            String account = scanner.nextLine();
            System.out.println("Vui lòng nhập mật khẩu: ");
            String password = scanner.nextLine();
            if (employeeModel.checkExistAccount(account)) {
                System.err.println("Tài khoản đã tồn tại, vui lòng chọn tên tài khoản khác.");
                break;
            } else {
                Employee employee = new Employee(name, address, email, account, password);
                employeeModel.register(employee);
                System.out.println("Đăng ký thành công với tài khoản: " + account);
                break;
            }

        }
    }

    public void login() {
        System.out.println("----------Đăng nhập--------");
        System.out.println("Vui lòng nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.println("Vui lòng nhập mật khẩu: ");
        String password = scanner.nextLine();

        Employee employee = employeeModel.login(account, password);
        if (employee == null) {
            System.err.println("Sai tài khoản hoặc mật khẩu, vui lòng kiểm tra và đăng nhập lại!\n");
        } else {
            System.out.println("Đăng nhập thành công! dưới đây là thông tin tài khoản: ");
            System.out.println("------------------------------------------------------");
            System.out.println("Tên: " + employee.getName());
            System.out.println("\nĐịa chỉ: " + employee.getAddress());
            System.out.println("\nEmail: " + employee.getEmail());
            System.out.println("\nTài khoản: " + employee.getAccount());
            System.out.println("\nMật khẩu: " + employee.getPassword());
            System.out.println("\nNgày tạo: " + employee.getCreateAt());
        }

    }
}
