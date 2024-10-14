Feature: API Testing with Authorization
  @Api
  Scenario: Create a new post
    Given I have the API URL
    When I send a POST request with the following data
      | title   | body | userId |
      | Testing | Demo | 1      |
    Then I receive a success response