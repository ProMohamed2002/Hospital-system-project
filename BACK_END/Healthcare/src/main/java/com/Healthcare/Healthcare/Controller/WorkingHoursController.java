package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Entity.WorkingHours;
import com.Healthcare.Healthcare.Service.PatientService;
import com.Healthcare.Healthcare.Service.WorkingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkingHoursController {

    @Autowired
    private WorkingHoursService workingHoursService;

    @PostMapping("/addWorkingHours")
    public WorkingHours postDetails(@RequestBody WorkingHours workingHours) {
        return workingHoursService.saveWorkingHours(workingHours);
    }
    @GetMapping("/customFetchWorkingHoursByDoctor")
    public List<WorkingHours> fetchController(@RequestParam String doctor) {
        return workingHoursService.fetchWorkingHoursByDoctor(doctor);
    }

    @GetMapping("/customFetchWorkingHours")
    public List<WorkingHours> fetchController() {
        return workingHoursService.fetchAllWorkingHours();
    }

    @GetMapping("/customWeekDayAndDoctor")
    public List<WorkingHours> customFetch(@RequestParam String week_day, @RequestParam String doctor) {
        return workingHoursService.fetchWorkingHoursUsingDayAndDoctor(week_day, doctor);
    }

    @DeleteMapping("/customDeleteWorkingHours")
    public void customDelete(@RequestParam String day, @RequestParam String doctor) {
        workingHoursService.deleteWeekDayByDayAndDoctor(day, doctor);
    }


}