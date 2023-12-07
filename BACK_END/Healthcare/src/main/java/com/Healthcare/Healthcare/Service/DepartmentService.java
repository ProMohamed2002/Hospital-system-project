package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.Department;
import com.Healthcare.Healthcare.Repository.DepartmentRepo;
import com.Healthcare.Healthcare.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public List<Department> fetchAllDepartments() {
        return departmentRepo.fetchAllFromCustom();
    }

    public List<Department> fetchDepartmentsUsingHospital(String hospital) {
        return departmentRepo.fetchDepartmentsUsingHospital(hospital);
    }

    public void deleteDepartmentByName(String name, String hospital) {
        departmentRepo.deleteDepartmentByName(name, hospital);
    }

    public Department updateDepartmentByName(Department department) {
        Department updateDepartment = departmentRepo.getDepartmentByName(department.getName(), department.getHospital());
        if(updateDepartment != null) {
            updateDepartment.setName(department.getName());
            updateDepartment.setHospital(department.getHospital());
            departmentRepo.save(updateDepartment);
            return updateDepartment;
        }
        return null;
    }
}
