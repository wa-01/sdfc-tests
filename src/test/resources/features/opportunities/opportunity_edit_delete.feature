Feature: Opportunities

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Opportunities"

  Scenario: Edit Opportunity from table
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName        | value               |
      | text          | Opportunity Name | auto-opportunity-01 |
      | text          | Close Date       | 7/12/2019           |
      | select_option | Stage            | Needs Analysis      |
    And I validate the notification message says 'Opportunity "auto-opportunity-01" was created.'
    And I validate the selected stage in the view page is "Needs Analysis"
    And I click on the "Opportunities" tab
    And I edit the opportunity "auto-opportunity-01" in the table with the following values
      | name       | opportunity-to-delete |
      | close_date | 9/11/2019             |
      | stage      | Value Proposition     |
    And I click "Save" button after edit the opportunity table
    Then I validate the name "opportunity-to-delete" is in the "Opportunities" menu
    And I click the opportunity "opportunity-to-delete" in the table
    And I validate the opportunity view page displays
      | opportunity_name | opportunity-to-delete |
      | close_date       | 9/11/2019             |
    And I validate the selected stage in the view page is "Value Proposition"
    And I go to opportunity "Details"
    And I validate the values set in the Opportunity Details are
      | Opportunity Name | opportunity-to-delete |
      | Close Date       | 9/11/2019             |
      | Stage            | Value Proposition     |

  Scenario: Delete Opportunity
    When I select the opportunity "opportunity-to-delete" and click the "Delete" action
    And I click "Delete" in the modal dialog
    Then I validate the notification message says 'Opportunity "opportunity-to-delete" was deleted.'
    And I validate the opportunity "opportunity-to-delete" is not in the "Opportunities" menu
    And I validate the opportunity "opportunity-to-delete" is not in the table
