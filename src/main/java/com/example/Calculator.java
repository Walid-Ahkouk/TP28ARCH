package com.example;

public class Calculator {

    // Code Smell: Public static mutable field
    public static int UsageCount = 0;

    public int add(int a, int b) {
        // Code Smell: Unused variable
        int temp = 0;
        UsageCount++;
        return a + b;
    }

    public void riskyOperation() {
        try {
            // Bug: Division by zero possible inside logic (simplified here)
            int result = 10 / 0;
        } catch (Exception e) {
            // Code Smell: Empty catch block, exception ignored
        }
    }

    public boolean login(String username, String password) {
        // Security Hotspot: Hardcoded credential
        if ("admin123".equals(password)) {
            System.out.println("Welcome " + username);
            return true;
        }
        return false;
    }
    
    // Duplication candidate if copied
    public int subtract(int a, int b) {
        UsageCount++;
        return a - b;
    }
}
