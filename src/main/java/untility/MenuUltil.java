package untility;

import controller.EmployeeController;

import java.util.Scanner;

public class MenuUltil {
    EmployeeController employeeController = new EmployeeController();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n-------------MENU-------------");
            System.out.println("1. Đăng ký tài khoản.");
            System.out.println("2. Đăng nhập.");
            System.out.println("3. Thoát");
            System.out.println("---------------------------------");
            System.out.println("Vui lòng nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    employeeController.registerAccount();
                    break;
                case 2:
                    employeeController.login();
                    break;

                case 3:

                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng chọn từ 1 đến 3.");
                    break;
            }
            if (choice == 3) {
                System.out.println("Đã thoát, hẹn gặp lại!");
                break;
            }
        }
    }
}
