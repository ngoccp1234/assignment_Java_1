package entity;

import java.util.Date;

public class Employee {
    private String name;
    private String address;
    private String email;
    private String account;
    private String password;
    private Date createAt;
    private String updateAt;
    private String status;


    public Employee() {
    }

    public Employee(String name, String address, String email, String account, String password, Date createAt, String updateAt, String status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
    }

    public Employee(String name, String address, String email, String account, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

