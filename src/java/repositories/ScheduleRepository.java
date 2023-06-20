/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author acer
 */
public class ScheduleRepository {
    public List<LocalDate> startEndDates(int i) {
        LocalDate now = LocalDate.now();
        LocalDate selectedDate= now.plusDays(i*7);
        List<LocalDate> collect = Arrays.asList(DayOfWeek.values()).stream().map(selectedDate::with).collect(toList());
        LocalDate startDate = collect.get(0);
        LocalDate endDate = collect.get(6);
        List<LocalDate> startEndDates = Arrays.asList(startDate,endDate);
        return startEndDates;
    }
}
