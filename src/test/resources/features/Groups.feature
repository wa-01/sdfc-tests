Feature: Groups
  As a user I want to have group

  Scenario: Create group
    Given I sign in as "rpfh1@mailinator.com" user and "654321*Aa"
    When I click the new button
    And I set these value to form
      | Name        | New Group       |
      | Owner       | Rosario Falconi |
      | Access Type | Public          |
    And I click "Save & Next" button
    And I click "Next" button
    And I click "Done" button
    Then New group dashboard is displayed