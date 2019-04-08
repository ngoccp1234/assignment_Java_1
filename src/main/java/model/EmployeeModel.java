package model;

import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeModel {
//    private ArrayList<String> errors;


    private Connection connection;

//    private ArrayList<String> checkAccount;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                    DriverManager.
                            getConnection("jdbc:mysql://localhost:3306/human_source?user=root&password=");
        }
    }

    public boolean register(Employee emp) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into employees(name, address, email, account, password) values(?,?,?,?,?)");
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getAddress());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getAccount());
            preparedStatement.setString(5, emp.getPassword());
            preparedStatement.execute();
            return true;

        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại sau. Error: " + ex.getMessage());
        }
        return false;

    }

    public boolean checkExistAccount(String account) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from  employees where account = ?");
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại sau. Error: " + ex.getMessage());
            return false;
        }
        return false;
    }

    public Employee login(String account, String password) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ? and password = ?");
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String address = resultSet.getString(2);
                String email = resultSet.getString(3);
                String accounts = resultSet.getString(4);
                String passwords = resultSet.getString(5);
                Date createAt = resultSet.getDate(6);
                String updateAt = resultSet.getString(7);
                String status = resultSet.getString(8);
                Employee emp = new Employee(name, address, email, accounts, passwords, createAt, updateAt, status);
                return emp;
            }
        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại sau. Error: " + ex.getMessage());
        }
        return null;
    }

}





