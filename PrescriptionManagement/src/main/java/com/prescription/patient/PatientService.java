package com.prescription.patient;

import java.util.List;

/**
 * Service interface for Patient operations
 */
public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient getPatientByEmail(String email);

    List<Patient> searchPatientsByName(String name);

    List<Patient> getPatientsByBloodType(String bloodType);

    Patient createPatient(Patient patient);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);
}
