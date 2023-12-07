package com.Healthcare.Healthcare.Service;


import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient saveDetails(Patient patient) {
        return patientRepo.save(patient);
    }

    public List<Patient> getAllDetails() {
        return patientRepo.findAll();
    }

    public Patient getPatientDetailsById(int id) {
        return patientRepo.findById(id).orElse(null);
    }

    public Patient updateDetails(Patient patient) {
        Patient updatePatient = patientRepo.fetchPatientUsingNameAndCivilID(patient.getUser_name(), patient.getCivil_id());

        if(updatePatient != null) {
            updatePatient.setBirth_date(patient.getBirth_date());
            updatePatient.setCivil_id(patient.getCivil_id());
            updatePatient.setEmail_address(patient.getEmail_address());
            updatePatient.setPhone_number(patient.getPhone_number());
            updatePatient.setUser_name(patient.getUser_name());
            updatePatient.setPassword(patient.getPassword());
            patientRepo.save(updatePatient);
            return updatePatient;
        }
        return null;
    }

    public String deletePatient(int id) {
        if(patientRepo.existsById(id)) {
            patientRepo.deleteById(id);
            return "DELETED" + id;
        }
        else {
            return "id not there";
        }
    }

    public List<Patient> fetchAllPatients() {
        return patientRepo.fetchAllFromCustom();
    }

    public Patient fetchUsingNameAndPassword(String user_name, String password) {
        return patientRepo.fetchPatientUsingNameAndPassword(user_name, password);
    }

}
