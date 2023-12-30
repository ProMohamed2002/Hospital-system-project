package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Department;
import com.Healthcare.Healthcare.Entity.Doctor;
import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Service.DepartmentService;
import com.Healthcare.Healthcare.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public Department postDetails(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/customFetchDepartment")
    public List<Department> fetchController() {
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("/customHospital")
    public List<Department> customFetch(@RequestParam String hospital) {
        return departmentService.fetchDepartmentsUsingHospital(hospital);
    }

    @DeleteMapping("/customDeleteDepartment")
    public void customDelete(@RequestParam String name, @RequestParam String hospital) {
        departmentService.deleteDepartmentByName(name, hospital);
    }

    @PutMapping("/customUpdateDepartment")
    public Department customUpdate(@RequestBody Department department) {
        return departmentService.updateDepartmentByName(department);
    }
}
