Feature: Create new asset
  Background:
    Given I sign in as "mauricio.ramirez.f@gmail.com" user and "tujxuz-mobwuj-2xuFme" as password

  Scenario: Create Basic Asset
    And I click on the AppLauncher Icon
    And I select the item "Assets"
    And I click on Assets Page "New" button
    And I set the create form
      | fieldType     | fieldName    | value            |
      | text          | Asset Name  | test123           |
      | select        | Account     | test-account-1    |

    When I click the "Save" button on new item Form Page

    Then I should see a new row
