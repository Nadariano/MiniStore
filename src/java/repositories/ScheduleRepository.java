/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static java.util.stream.Collectors.toList;
import services.Utilities;
import static services.Utilities.sdfDate;

/**
 *
 * @author acer
 */
public class ScheduleRepository {

    public List<LocalDate> startEndDates(LocalDate selectedDate) {
//        LocalDate now = LocalDate.now();
//        LocalDate selectedDate= now.plusDays(i*7);
        List<LocalDate> collect = Arrays.asList(DayOfWeek.values()).stream().map(selectedDate::with).collect(toList());
        LocalDate startDate = collect.get(0);
        LocalDate endDate = collect.get(6);
        List<LocalDate> startEndDates = Arrays.asList(startDate, endDate);
        return startEndDates;
    }

    //List StartDates of the next 5 weeks
    public List<String> listStartEndDates() {
        List<String> listStartEndDates = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (int i = 0; i < 5; i++) {
            List<LocalDate> startEndDates = startEndDates(now.plusDays(i * 7));
            LocalDate lst = startEndDates.get(0);
            LocalDate led = startEndDates.get(1);
            Date st = Utilities.localDateIntoDate(lst);
            Date ed = Utilities.localDateIntoDate(led);
            String startDate = sdfDate.format(st);
            String endDate = sdfDate.format(ed);
            String sed = startDate + " - " + endDate;
            listStartEndDates.add(sed);
        }
        return listStartEndDates;
    }

}
