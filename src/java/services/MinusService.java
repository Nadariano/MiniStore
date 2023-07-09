/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class MinusService {

    public static float lateTime(Date date, Date lateTime) {

        long d = date.getTime();
        Date test = new Date(d);
        System.out.println("date test: " + test);
        System.out.println("late test: " + lateTime);
        
        
        long minute = 0;
        if (lateTime == null) {
            return 0;
        }
        minute = lateTime.getTime() - date.getTime();
        if (minute >= 0) {
            float late = (float) minute / 1000 / 60 / 60;
            System.out.println("lateTime: " + late);
            return late;
        } else {
            System.out.println("lateTimeee: " + 0);
            return 0;
        }
    }
    
    public static float soonTime(Date date, Date soonTime) {
        long minute = 0;
        if (soonTime == null) {
            return 0;
        }
        minute = soonTime.getTime() - date.getTime();
        if (minute >= 0) {
            float soon = (float) minute / 1000 / 60 / 60;
            System.out.println("soonTime: " + soon);
            return soon;
        } else {
            System.out.println("soonTimeee: " + 0);
            return 0;
        }
    }
    public static float lateTime1(Date date, Date lateTime) {

        long minute = 0;
        if (lateTime == null) {
            return 0;
        }
        minute = lateTime.getTime() - date.getTime();
        if (minute > 0) {
            float late = (float) minute / 1000 / 60 / 60;
            return late;
        } else {
            return 0;
        }
    }

}
