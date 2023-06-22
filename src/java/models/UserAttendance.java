/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import repositories.AttendanceRepository;

/**
 *
 * @author Dell
 */
public class UserAttendance {

    private Map<Integer, Item> map;

    public UserAttendance() {
        map = new HashMap<>();

    }

    public void add(int userID) throws SQLException {
        AttendanceRepository ar = new AttendanceRepository();
        HashMap<Integer, Attendance> userAttendance = ar.selectUserAttendance(userID);
        for (Map.Entry<Integer, Attendance> entry : userAttendance.entrySet()) {
            Attendance attendance = entry.getValue();
            Item item = new Item(attendance, attendance.getConfirm());
            map.put(entry.getKey(), item);
        }
    }

    public void update(int attendID, String confirm) {
        Item item = map.get(attendID);
        item.setConfirm(confirm);
    }

    public void remove(int attendID) {
        map.remove(attendID);
    }

    public void empty() {
        map.clear();
    }

    public Collection<Item> getItem() {
        return map.values();
    }
}
