Feature: Accounts

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Accounts"
    And I click on the Add New Account button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName    | value          |
      | text      | Account Name | AccountTest02203 |

  Scenario: Edit account

    When I click on account "Details" tab
    And I click on "Edit Account Name" option button
    And I add on the name "AccountTest02203edited" string.
    And I click on "Save" button
    Then I validate the account name is "AccountTest02203edited"
    And I click on the AppLauncher Icon
    And I select the item "Accounts"
    And I validate the account "AccountTest02203edited" is displayed in accounts table


