Feature: Accounts

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Accounts"
    And I click on the Add New Account button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName    | value          |
      | text      | Account Name | AccountTest02203 |

  Scenario: Delete account

    When I click on the Header dropDown Button
    And I click on delete option
    And I click on delete button
    Then I validate the following success message is displayed 'Account "AccountTest02203" was deleted.'
