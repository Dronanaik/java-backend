package com.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Main application class for Transaction Processing System
 * 
 * Features:
 * - Daily Transaction Limits
 * - Fraud Detection Rules
 * - Currency Conversion
 * - Transaction Reversal Logic
 * - Standing Instructions
 * - Bill Payment Scheduling
 * - Insufficient Funds Check
 * - Transaction Fee Calculation
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        System.out.println("\n" + "=".repeat(80));
        System.out.println("✅ Transaction Processing System Started Successfully!");
        System.out.println("🌐 Server running on: http://localhost:8080");
        System.out.println("📡 API Base URL: http://localhost:8080/api");
        System.out.println("=".repeat(80) + "\n");
    }
}
