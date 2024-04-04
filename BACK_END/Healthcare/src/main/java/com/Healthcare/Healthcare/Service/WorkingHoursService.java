package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.WorkingHours;
import com.Healthcare.Healthcare.Repository.WorkingHoursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingHoursService {


    @Autowired
    private WorkingHoursRepo workingHoursRepo;
    public WorkingHours saveWorkingHours(WorkingHours workingHours) {
        return workingHoursRepo.save(workingHours);
    }

    public List<WorkingHours> fetchAllWorkingHours() {
        return workingHoursRepo.fetchAllFromCustom();
    }

    public List<WorkingHours> fetchWorkingHoursUsingDayAndDoctor(String weekDay, String doctor) {
        return workingHoursRepo.fetchWorkingHoursUsingDayAndDoctor(weekDay, doctor);
    }

    public void deleteWeekDayByDayAndDoctor(String day, String doctor) {
        workingHoursRepo.deleteWorkingHoursByDayAndDoctor(day, doctor);
    }
    public List<WorkingHours> fetchWorkingHoursUsingDoctor(String doctor)
    {

        return workingHoursRepo.fetchWorkingHoursUsingDoctor(doctor);
    }
    public List<WorkingHours> fetchWorkingHoursByDoctor(String doctor) {
        return workingHoursRepo.fetchWorkingHoursUsingDoctor(doctor);
    }
}
