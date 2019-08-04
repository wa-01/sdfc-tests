Feature: Opportunities

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Opportunities"

  Scenario: Check Opportunity is not created when required fields are not filled
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName | value  |
      | text      | Amount    | 15.0   |
      | checkbox  | Private   | select |
    Then I validate the create form an error message says "These required fields must be completed: Close Date, Opportunity Name, Stage"
    And I validate these fields are required to complete in the form
      | Opportunity Name |
      | Close Date       |
      | Stage            |

  Scenario: Create Opportunity with only required fields
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName        | value               |
      | text          | Opportunity Name | auto-opportunity-00 |
      | text          | Close Date       | 1/1/2020          |
      | select_option | Stage            | Prospecting         |
    Then I validate the notification message says 'Opportunity "auto-opportunity-00" was created.'
    And I validate the opportunity view page displays
      | opportunity_name | auto-opportunity-00 |
      | close_date       | 1/1/2020          |
    And I validate the selected stage in the view page is "Prospecting"
    And I go to opportunity "Details"
    And I validate the values set in the Opportunity Details are
      | Opportunity Name | auto-opportunity-00 |
      | Close Date       | 1/1/2020          |
      | Stage            | Prospecting         |
    And I click on the "Opportunities" tab
    And I validate the name "auto-opportunity-00" is in the "Opportunities" menu
    And I validate the opportunity "auto-opportunity-00" is in table and the row has the following values
      | close_date | 1/1/2020  |
      | stage      | Prospecting |

  Scenario Outline: Create public/private basic Opportunity
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName        | value         |
      | text          | Opportunity Name | <name>        |
      | text          | Close Date       | <close_date>  |
      | text          | Amount           | <amount>      |
      | select_option | Stage            | <stage>       |
      | checkbox      | Private          | <private>     |
      | select_option | Type             | <type>        |
      | text_area     | Description      | <description> |
    Then I validate the notification message says 'Opportunity "<name>" was created.'
    And I validate the opportunity view page displays
      | opportunity_name | <name>       |
      | close_date       | <close_date> |
      | amount           | $<amount>    |
    And I validate the selected stage in the view page is "<stage>"
    And I go to opportunity "Details"
    And I validate the values set in the Opportunity Details are
      | Opportunity Name | <name>        |
      | Private          | <private>     |
      | Close Date       | <close_date>  |
      | Amount           | $<amount>     |
      | Stage            | <stage>       |
      | Type             | <type>        |
      | Description      | <description> |
    And I click on the "Opportunities" tab
    And I validate the name "<name>" is in the "Opportunities" menu
    And I validate the opportunity "<name>" is in table and the row has the following values
      | close_date | <close_date> |
      | stage      | <stage>      |
    Examples:
      | name                | close_date | stage          | private  | amount | description      | type                          |
      | auto-opportunity-01 | 7/12/2019  | Prospecting    | select   | 15.00  | A description 01 | Existing Customer - Downgrade |
      | auto-opportunity-02 | 8/11/2019  | Needs Analysis | unselect | 17.00  | A description 02 | Existing Customer - Upgrade   |