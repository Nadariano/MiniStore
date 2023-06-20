/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author acer
 */
public class StartEndDatesMap {
    private Map<Integer, StartEndDate> map;

    public StartEndDatesMap(){
        map = new HashMap<>();
    }

//    public void add(int i){
//        LocalDate startDate= startEndDate.getStartDate();
//        if(map.containsKey(startDate)){
//            StartEndDate oldItem = map.get(startDate);
//            oldItem.setQuantity(oldItem.getQuantity()+ item.getQuantity());
//        } else{
//            map.put(id, item);
//        }
//    }
    
}
