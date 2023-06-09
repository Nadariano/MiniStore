/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Pc
 */
public class Role {

    private int roleID;
    private String roleName;
    private int roleStatus;
    private String description;
    private String statusText;

    public Role() {
    }

    public Role(String roleName, int roleStatus, String description) {

        this.roleName = roleName;
        this.roleStatus = roleStatus;
        this.description = description;
    }

    public Role(int roleID, String roleName, int roleStatus, String description) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.roleStatus = roleStatus;
        this.description = description;

    }

    public Role(String roleName, String statusText, String description) {

        this.roleName = roleName;
        this.description = description;
        this.statusText = statusText;
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

    public int getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(int roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

}
