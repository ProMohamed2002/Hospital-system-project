package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.WeekDays;
import com.Healthcare.Healthcare.Repository.WeekDaysRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekDaysService {

    @Autowired
    private WeekDaysRepo weekDaysRepo;


    public WeekDays saveWeekDays(WeekDays weekDays) {
        return weekDaysRepo.save(weekDays);
    }

    public List<WeekDays> fetchAllWeekDays() {
        return weekDaysRepo.fetchAllFromCustom();
    }

    public List<WeekDays> fetchWeekDaysUsingNameAndPassword(String doctor) {
        return weekDaysRepo.fetchWeekDaysUsingDoctor(doctor);
    }

    public void deleteWeekDayByNameAndDoctor(String name, String doctor) {
        weekDaysRepo.deleteByNameAndDoctor(name, doctor);
    }
}
