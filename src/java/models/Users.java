/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Dell
 */
public class Users {

    private int userID;
    private String userName;
    private String password;
    private String fullName;
    private String avatar;
    private String address;
    private String phone;
    private String email;
    private int status;
    private String statusText1;
    private String note;
    private int roleID;
    private String roleName;

    public Users() {
    }

    public Users(int userID, String userName, String password, String fullName, String avatar, String address, String phone, String email, int status, String statusText1, String note, int roleID, String roleName) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.statusText1 = statusText1;
        this.note = note;
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public Users(String userName, String password, String fullName, String avatar, String address, String phone, String email, int status, String note, int roleID) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.note = note;
        this.roleID = roleID;
    }

    public Users(int userID, String userName, String password, String fullName, String avatar, String address, String phone, String email, int status, String note, int roleID) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.note = note;
        this.roleID = roleID;
    }

    public Users(int userID, String userName, String password, String fullName, String avatar, String address, String phone, String email, int status, String note, int roleID, String roleName) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.note = note;
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatusText1() {
        return statusText1;
    }

    public void setStatusText1(String statusText1) {
        this.statusText1 = statusText1;
    }

}
