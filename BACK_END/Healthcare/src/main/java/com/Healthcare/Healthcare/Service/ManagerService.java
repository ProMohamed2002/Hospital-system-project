package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.Doctor;
import com.Healthcare.Healthcare.Entity.Manager;
import com.Healthcare.Healthcare.Repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;
    public Manager saveManager(Manager manager) {
        return managerRepo.save(manager);
    }

    public List<Manager> fetchAllManagers() {
        return managerRepo.fetchAllFromCustom();
    }

    public Manager fetchManagersUsingNameAndPassword(String userName, String password) {
        return managerRepo.fetchManagersUsingNameAndPassword(userName, password);
    }

    public Manager updateManagerByNameAndCivilID(Manager manager) {
        Manager updateManager = managerRepo.getManagerByNameAndCivilID(manager.getUser_name(), manager.getCivil_id());
        if(updateManager != null) {
            updateManager.setBirth_date(manager.getBirth_date());
            updateManager.setCivil_id(manager.getCivil_id());
            updateManager.setEmail_address(manager.getEmail_address());
            updateManager.setPhone_number(manager.getPhone_number());
            updateManager.setUser_name(manager.getUser_name());
            updateManager.setPassword(manager.getPassword());
            managerRepo.save(updateManager);
            return updateManager;
        }
        return null;
    }
}
