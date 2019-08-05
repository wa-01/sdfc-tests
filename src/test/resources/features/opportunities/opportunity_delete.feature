Feature: Delete Opportunity

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Opportunities"
    And I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName        | value               |
      | text          | Opportunity Name | opportunity-to-delete |
      | text          | Close Date       | 7/12/2019           |
      | select_option | Stage            | Needs Analysis      |
    And I validate the notification message says 'Opportunity "opportunity-to-delete" was created.'
    And I validate the selected stage in the view page is "Needs Analysis"

  Scenario:
    When I click on the "Opportunities" tab
    And I select the opportunity "opportunity-to-delete" and click the "Delete" action
    And I click "Delete" in the modal dialog
    Then I validate the notification message says 'Opportunity "opportunity-to-delete" was deleted.'
    And I validate the opportunity "opportunity-to-delete" is not in the "Opportunities" menu
    And I validate the opportunity "opportunity-to-delete" is not in the table