package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Department;
import com.Healthcare.Healthcare.Entity.Doctor;
import com.Healthcare.Healthcare.Entity.Manager;
import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Service.DepartmentService;
import com.Healthcare.Healthcare.Service.ManagerService;
import com.Healthcare.Healthcare.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/addManager")
    public Manager postDetails(@RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }

    @GetMapping("/customFetchManager")
    public List<Manager> fetchController() {
        return managerService.fetchAllManagers();
    }

    @GetMapping("/customManagerNameAndPassword")
    public Manager customFetch(@RequestParam String user_name, @RequestParam String password) {
        return managerService.fetchManagersUsingNameAndPassword(user_name, password);
    }

    @PostMapping("/customUpdateManager")
    public Manager customUpdate(@RequestBody Manager manager) {
        return managerService.updateManagerByNameAndCivilID(manager);
    }
}
