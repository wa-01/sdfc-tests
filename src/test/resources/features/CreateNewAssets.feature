Feature: Create new asset

  Scenario: Create Basic Asset
    Given I sign in as "username" user and "password" as password
    And I click on the AppLauncher Icon
    And I select the item "Assets"
    And I click on the "New" button
    And I set the create form
      | fieldName   | Asset Name    | Account           |
      | fieldType   | text          | select            |
      | value       | test123       | test-account-1    |

    When I click the save button

    Then I should see a new row
