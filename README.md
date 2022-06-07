# seera-backend-assignment
-  Technical Details : Rest Assured Framework with BDD, Cucumber, Java & Maven.
-  Git link to clone the project : https://github.com/saurabh150891/seera-backend-assignment.git
       
- Navigate to path "\src\test\java\cucumber\options\TestRunner.java" for Test Execution
       
       - To run all the cases under PostAsyncSearchAPI.feature, use the annotation @PostAsyncSearchAPI
       - To run all the cases under GetAutoCompleteAPI.feature, use the annotation @GetAutoCompleteAPI 
       - To run all the test cases send tags as empty

- Navigate to path "\src\test\java\features" for feature files.

      - GetAutoCompleteAPI.feature : Contains all the scenarios for GET API
      - PostAysncSearchAPI.feature : Contains all the scenarios for POST API
      - Note --> Request body and response are created and asserted using POJOs. The same POJO classes ensure schema validation

- Navigate to file "\seera-backend-assignment\logging.txt". In this file API Requests and Responses are logged. This file will be created post execution of test cases

- Navigate to file "\seera-backend-assignment\global.properties". This file contains global properties like token, baseURI

- Navigate to path "\seera-backend-assignment\target\cucumber-reports\cucumber.html". Refer the file index.html at this path for cucumber report.

- Refer to comments above methods in the BaseStepDefinitions file that describes the methods. 
