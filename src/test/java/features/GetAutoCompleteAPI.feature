@GetAutoCompleteAPI
Feature: Auto complete API Tests

  Scenario Outline: Validate if the autocomplete API request is successful | "<scenarioName>"
    Given set query parameters in request
      | query | <queryValue> |
    And set request token "<token>"
    When call the "autocompleteAPI" with "GET" http request
    Then verify response status is 200
    And verify response content type is Json
    And verify autoCompleteResponse for hotels
    And verify autoCompleteResponse for locations

#token: Pass as "default" to fetch the default token from global.properties file
#schema validation is happening with the help of POJO classes

    Examples:
      | scenarioName              | queryValue | token   |
      | Happy Path - place Dubai  | Dubai      | default |
      | Happy Path - place London | Dubai      | default |


  Scenario Outline: Validate if the autocomplete API is throwing bad request error | "<scenarioName>"
    Given set query parameters in request
      | query | <queryValue> |
    And set request token "<token>"
    When call the "autocompleteAPI" with "GET" http request
    Then verify response status is 400

    Examples:
      | scenarioName                    | queryValue | token   |
      | Negative Scenario - Query Value |            | default |
      | Negative Scenario - Query Value | ++         | default |


  Scenario Outline: Validate if the autocomplete API is throwing Unauthorized error | "<scenarioName>"
    Given set query parameters in request
      | query | <queryValue> |
    And set request token "<token>"
    When call the "autocompleteAPI" with "GET" http request
    Then verify response status is 401

    Examples:
      | scenarioName                      | queryValue | token   |
      | Unauthorized Error - InvalidToken | Dubai      | invalid |