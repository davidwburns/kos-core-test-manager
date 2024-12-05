package com.kondra.kos.tester;

import com.tccc.kos.commons.core.dispatcher.annotations.ApiController;
import com.tccc.kos.commons.core.dispatcher.annotations.ApiEndpoint;
import com.tccc.kos.commons.core.dispatcher.annotations.RequestParam;
import java.util.ArrayList;
import java.util.List;

@ApiController(base = "/tests", title="Test Manager Controller")
public class TestController {

    private TestManager testManager = new TestManager();

    @ApiEndpoint(GET = "/all", desc = "returns all tests")
    public List<String> getAllTests() {
        List<String> testNames = new ArrayList<>();
        for (Testable service : testManager.getTestableServices()) {
            testNames.add(service.getTestName());
        }
        return testNames;
    }

    @ApiEndpoint(POST = "/run", desc = "runs test",
            params = @ApiEndpoint.Param(name = "testName", desc = "name of test"))
    public String runTestByName(@RequestParam String testName) {
        try {
            testManager.runTestByName(testName);
            return "Test " + testName + " executed successfully.";
        } catch (Exception e) {
            return "Test " + testName + " execution failed with exception: " + e.getMessage();
        }
    }

    @ApiEndpoint(GET = "/runAll", desc = "runs all tests")
    public String runAllTests() {
        try {
            testManager.runAllTests();
            return "All tests executed successfully.";
        } catch (Exception e) {
            return "Execution of all tests failed with exception: " + e.getMessage();
        }
    }
}

