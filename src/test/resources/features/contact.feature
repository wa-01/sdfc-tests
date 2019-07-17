Feature: Contactas

  Scenario: Create a Contact
    Given I sign in as "username" user and "password" as password
    And I click on the AppLauncher Icon
    And I select the item "Contacts"
    When I click the new button
    And I set the contact form
      | LastName | MyContact |
    Then I validate the contact label is "MyContact"