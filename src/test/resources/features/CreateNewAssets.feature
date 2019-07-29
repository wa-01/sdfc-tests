Feature: Create new asset
  Background:
    Given I sign in as "mauricio.ramirez.f@gmail.com" user and "tujxuz-mobwuj-2xuFme" as password

  Scenario: Create Basic Asset
    And I click on the AppLauncher Icon
    And I select the item "Assets"
    And I click on Assets Page "New" button
    And I fill the create form with
      | fieldType   | fieldName      | value             |
      | text        | Asset Name     | test123           |
      | text        | Serial Number  | 1234567899        |
      | text_option | Account        | test-account-1    |

    When I click the "Save" button on new item Form Page

    Then I verify that the title on "Asset" page is "test123"
    And I verify that "Asset Name" inner form text field is "test123"
    And I verify that "test123" is on dropdown menu of "Assets" tab
