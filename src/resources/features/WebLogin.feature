Feature: Login to Web application

  @Ui
  Scenario: Test 1
    Given I Open the application
    When I enter Username and Password
    When Click on Login Button
    Then Verify that landing to dashboard page "Swag Labs"
    And I select a item and Added in cart