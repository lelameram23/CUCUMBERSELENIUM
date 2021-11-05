Feature: Login

  Scenario: N11 Login

   Given User navigate to the login page
    And User click login button
    And User click login with Facebook button
    When User enter the email as "xxx" and password as "xsdvfgtf"
    Then User should see login mail