package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.Doctor;
import com.Healthcare.Healthcare.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> fetchAllDoctors() {
        return doctorRepo.fetchAllFromCustom();
    }

    public List<Doctor> fetchDoctorsUsingHospitalAndDepartment(String hospital, String department) {
        return doctorRepo.fetchDoctorsUsingHospitalAndDepartment(hospital, department);
    }

    public void deleteDoctorByName(String user_name, String hospital, String department) {
        doctorRepo.deleteDoctorByName(user_name, hospital, department);
    }

    public Doctor updateDoctorByName(Doctor doctor) {
        Doctor updateDoctor = doctorRepo.getDoctorByName(doctor.getUser_name(), doctor.getHospital(), doctor.getDepartment());
        if(updateDoctor != null) {
            updateDoctor.setBirth_date(doctor.getBirth_date());
            updateDoctor.setCivil_id(doctor.getCivil_id());
            updateDoctor.setEmail_address(doctor.getEmail_address());
            updateDoctor.setPhone_number(doctor.getPhone_number());
            updateDoctor.setUser_name(doctor.getUser_name());
            updateDoctor.setPassword(doctor.getPassword());
            doctorRepo.save(updateDoctor);
            return updateDoctor;
        }
        return null;
    }

    public Doctor getDoctorByNameAndPassword(String user_name, String password) {
        return doctorRepo.getDoctorByNameAndPassword(user_name, password);
    }

    public List<Doctor> customDoctorsByHospital(String hospital) {
        return doctorRepo.customDoctorsByHospital(hospital);
    }
}
