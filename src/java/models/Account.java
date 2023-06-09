/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author PHT
 */
public class Account {

    private int userID;
    private String userName;
    private String fullName;
    private String password;
    private String avatar;
    private String address;
    private String phone;
    private String email;
    private int status;
    private String roleName;

    public Account() {
    }

    public Account(int userID, String userName, String fullName, String password, String avatar, String address, String phone, String email, int status, String roleName) {
        this.userID = userID;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.roleName = roleName;
    }

    public Account(int userID, String userName, String fullName, String avatar, String address, String phone, String email) {
        this.userID = userID;
        this.userName = userName;
        this.fullName = fullName;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
