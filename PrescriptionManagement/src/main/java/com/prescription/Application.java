package com.prescription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application class for Prescription Management System
 * 
 * This application provides comprehensive prescription management features
 * including:
 * - Drug Interaction Check: Warn about dangerous drug combinations
 * - Allergy Validation: Check patient allergies before prescribing
 * - Dosage Calculation: Calculate dose based on age, weight
 * - Refill Authorization: Check if prescription allows refills
 * - Expiry Tracking: Alert about expiring prescriptions
 * 
 * @author Drona L
 * @version 1.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("✅ Prescription Management System Started Successfully!");
    }

}
