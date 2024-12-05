package com.kondra.kos.tester;

public interface Testable {
    String getTestName();
    void runTest() throws Exception;
    boolean isTestSuccessful();
    String getTestResult();
}

