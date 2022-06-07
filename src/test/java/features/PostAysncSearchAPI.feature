@PostAsyncSearchAPI
Feature: Async Search API Tests


  Scenario Outline: Validate if the Async search API request is successful | "<scenarioName>"
    Given Async API payload with "<checkInDate>" "<checkOutDate>" "<numberOfAdults>" "<numberOfKids>" "<placeId>"
    And set request token "<token>"
    When call the "asyncAPI" with "POST" http request
    Then verify response status is 200
    And verify response content type is Json
    And "sId" in response body is not null

#checkInDate/checkOutDate: Pass "default" to generate dynamic dates on runtime. Can pass actual dates also if required
#token: Pass as "default" to fetch the default token from global.properties file

    Examples:
      | scenarioName                 | checkInDate | checkOutDate | numberOfAdults | numberOfKids | token   | placeId                     |
      | Happy Path - placeId - Dubai | default     | default      | 1              | 1            | default | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ |
      | Happy Path - placeId - India | 2022-07-20  | 2022-07-27   | 2              | 3            | default | ChIJC03rqdriDDkRXT6SJRGXFwc |


  Scenario Outline: Validate if the async API request is throwing Bad Request | "<scenarioName>"
    Given Async API payload with "<checkInDate>" "<checkOutDate>" "<numberOfAdults>" "<numberOfKids>" "<placeId>"
    And set request token "<token>"
    When call the "asyncAPI" with "POST" http request
    Then verify response status is 400
    And validate the error response "<errorCode>"


    Examples:
      | scenarioName                              | checkInDate | checkOutDate | numberOfAdults | numberOfKids | placeId                     | token   | errorCode |
      | Negative Scenario - invalidCheckInDate    | 202-06-99   | default      | 1              | 1            | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default |           |
      | Negative Scenario - withoutCheckInDate    |             | default      | 1              | 1            | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default | 1015      |
      | Negative Scenario - pastCheckInDate       | 2022-01-03  | default      | 1              | 1            | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default |           |
      | Negative Scenario - invalidCheckOutDate   | default     | 202-06-99    | 1              | 1            | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default |           |
      | Negative Scenario - withoutCheckOutDate   | default     |              | 1              | 1            | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default | 1015      |
      | Negative Scenario - pastCheckOutDate      | default     | 2022-01-03   | 1              | 1            | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default |           |
      | Negative Scenario - invalidNumberOfAdults | default     | default      | 20             | 1            | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default |           |
      | Negative Scenario - invalidNumberOfKids   | default     | default      | 1              | 15           | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ | default |           |
      | Negative Scenario - invalidPlaceId        | default     | default      | 1              | 1            | invalid                     | default |           |


  Scenario Outline: Validate if the async API request is throwing Unauthorized error | "<scenarioName>"
    Given Async API payload with "<checkInDate>" "<checkOutDate>" "<numberOfAdults>" "<numberOfKids>" "<placeId>"
    And set request token "<token>"
    When call the "asyncAPI" with "POST" http request
    Then verify response status is 401

    Examples:
      | scenarioName                      | checkInDate | checkOutDate | numberOfAdults | numberOfKids | token   | placeId                     |
      | Unauthorized Error - invalidToken | default     | default      | 1              | 1            | invalid | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ |
      | Unauthorized Error - invalidToken | default     | default      | 1              | 1            |         | ChIJ7d_LEEJvXz4R8oq3hLV_PmQ |