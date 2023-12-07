package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.Department;
import com.Healthcare.Healthcare.Entity.Hospital;
import com.Healthcare.Healthcare.Repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepo hospitalRepo;
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    public List<Hospital> fetchAllHospitals() {
        return hospitalRepo.fetchAllFromCustom();
    }

    public List<Hospital> fetchHospitalsUsingName(String name) {
        return hospitalRepo.fetchHospitalsUsingName(name);
    }

    public void deleteHospitalByName(String name) {
        hospitalRepo.deleteHospitalByName(name);
    }

    public Hospital updateHospitalByName(Hospital hospital) {
        Hospital updateHospital = hospitalRepo.getHospitalByName(hospital.getName());
        if(updateHospital != null) {
            updateHospital.setName(hospital.getName());
            updateHospital.setEmail_address(hospital.getEmail_address());
            updateHospital.setClinics_number(hospital.getClinics_number());
            updateHospital.setIntensive_care_beds((hospital.getIntensive_care_beds()));
            updateHospital.setDoctors_number(hospital.getDoctors_number());
            hospitalRepo.save(updateHospital);
            return updateHospital;
        }
        return null;
    }
}
