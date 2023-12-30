package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Entity.WeekDays;
import com.Healthcare.Healthcare.Service.PatientService;
import com.Healthcare.Healthcare.Service.WeekDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeekDaysController {

    @Autowired
    private WeekDaysService weekDaysService;

    @PostMapping("/addWeekDay")
    public WeekDays postDetails(@RequestBody WeekDays weekDays) {
        return weekDaysService.saveWeekDays(weekDays);
    }

    @GetMapping("/customFetchWeekDays")
    public List<WeekDays> fetchController() {
        return weekDaysService.fetchAllWeekDays();
    }

    @GetMapping("/customWeekDays")
    public List<WeekDays> customFetch(@RequestParam String doctor) {
        return weekDaysService.fetchWeekDaysUsingNameAndPassword(doctor);
    }

    @DeleteMapping("/customDeleteWeekDay")
    public void customDelete(@RequestParam String name, @RequestParam String doctor) {
        weekDaysService.deleteWeekDayByNameAndDoctor(name, doctor);
    }
}
