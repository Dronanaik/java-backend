package com.prescription.interaction;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.prescription.drug.Drug;

/**
 * DrugInteraction Entity - Represents dangerous drug combinations
 * 
 * Features:
 * - Tracks interactions between two drugs
 * - Severity level (Minor, Moderate, Major, Contraindicated)
 * - Description of the interaction
 * - Recommendations for healthcare providers
 * - Used for drug interaction checks
 */
@Entity
@Table(name = "drug_interactions")
public class DrugInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug1_id", nullable = false)
    private Drug drug1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug2_id", nullable = false)
    private Drug drug2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InteractionSeverity severityLevel;

    @Column(length = 2000, nullable = false)
    private String description;

    @Column(length = 1000)
    private String recommendation;

    @Column(length = 1000)
    private String clinicalEffects;

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
    public DrugInteraction() {
    }

    public DrugInteraction(Drug drug1, Drug drug2, InteractionSeverity severityLevel,
            String description, String recommendation, String clinicalEffects) {
        this.drug1 = drug1;
        this.drug2 = drug2;
        this.severityLevel = severityLevel;
        this.description = description;
        this.recommendation = recommendation;
        this.clinicalEffects = clinicalEffects;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drug getDrug1() {
        return drug1;
    }

    public void setDrug1(Drug drug1) {
        this.drug1 = drug1;
    }

    public Drug getDrug2() {
        return drug2;
    }

    public void setDrug2(Drug drug2) {
        this.drug2 = drug2;
    }

    public InteractionSeverity getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(InteractionSeverity severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getClinicalEffects() {
        return clinicalEffects;
    }

    public void setClinicalEffects(String clinicalEffects) {
        this.clinicalEffects = clinicalEffects;
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
        return "DrugInteraction{" +
                "id=" + id +
                ", severityLevel=" + severityLevel +
                ", description='" + description + '\'' +
                '}';
    }

    // Enum for Interaction Severity
    public enum InteractionSeverity {
        MINOR, // Minimal clinical significance
        MODERATE, // Monitor closely
        MAJOR, // Avoid combination if possible
        CONTRAINDICATED // Do not use together
    }
}
