package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application class for Inventory Management System
 * 
 * This application provides comprehensive inventory management features
 * including:
 * - Multi-warehouse inventory tracking
 * - Stock transfer between warehouses
 * - Purchase order management
 * - Supplier management
 * - Sales order fulfillment
 * - Batch and expiry tracking
 * - Inventory valuation (FIFO/LIFO)
 * 
 * @author Drona L
 * @version 1.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("✅ Inventory Management System Started Successfully!");
    }

}
