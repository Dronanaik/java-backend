package com.prescription.allergy;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.prescription.patient.Patient;

/**
 * Allergy Entity - Represents a patient's allergy
 * 
 * Features:
 * - Allergen information
 * - Severity level (Mild, Moderate, Severe)
 * - Diagnosis date
 * - Notes and symptoms
 * - Used for allergy validation before prescribing
 */
@Entity
@Table(name = "allergies")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private String allergen; // e.g., "Penicillin", "Aspirin", "Peanuts"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeverityLevel severity;

    private LocalDate diagnosedDate;

    @Column(length = 1000)
    private String symptoms;

    @Column(length = 1000)
    private String notes;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Constructors
    public Allergy() {
    }

    public Allergy(Patient patient, String allergen, SeverityLevel severity,
            LocalDate diagnosedDate, String symptoms, String notes) {
        this.patient = patient;
        this.allergen = allergen;
        this.severity = severity;
        this.diagnosedDate = diagnosedDate;
        this.symptoms = symptoms;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public SeverityLevel getSeverity() {
        return severity;
    }

    public void setSeverity(SeverityLevel severity) {
        this.severity = severity;
    }

    public LocalDate getDiagnosedDate() {
        return diagnosedDate;
    }

    public void setDiagnosedDate(LocalDate diagnosedDate) {
        this.diagnosedDate = diagnosedDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Allergy{" +
                "id=" + id +
                ", allergen='" + allergen + '\'' +
                ", severity=" + severity +
                ", diagnosedDate=" + diagnosedDate +
                '}';
    }

    // Enum for Severity Level
    public enum SeverityLevel {
        MILD,
        MODERATE,
        SEVERE
    }
}
