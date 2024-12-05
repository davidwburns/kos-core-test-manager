package com.kondra.kos.tester;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

public class TestManager {
    @Getter
    private List<Testable> testableServices = new ArrayList<>();

    // Register a Testable service
    public void registerTestableService(Testable service) {
        testableServices.add(service);
    }

    // Run all registered tests
    public void runAllTests() {
        for (Testable service : testableServices) {
            try {
                service.runTest();
                System.out.println(service.getTestName() + ": " + service.getTestResult());
            } catch (Exception e) {
                System.err.println("Test " + service.getTestName() + " failed with exception: " + e.getMessage());
            }
        }
    }

    // Run a specific test by name
    public void runTestByName(String testName) {
        for (Testable service : testableServices) {
            if (service.getTestName().equals(testName)) {
                try {
                    service.runTest();
                    System.out.println(service.getTestName() + ": " + service.getTestResult());
                } catch (Exception e) {
                    System.err.println("Test " + service.getTestName() + " failed with exception: " + e.getMessage());
                }
                return;
            }
        }
        System.err.println("No test found with name: " + testName);
    }
}

