Feature: Opportunities

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Opportunities"

  Scenario: Edit Opportunity from table
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName        | value               |
      | text          | Opportunity Name | auto-opportunity-07 |
      | text          | Close Date       | 7/12/2019           |
      | select_option | Stage            | Needs Analysis      |
    And I validate the notification message says 'Opportunity "auto-opportunity-07" was created.'
    And I validate the selected stage in the view page is "Needs Analysis"
    And I click on the "Opportunities" tab
    And I edit the opportunity "auto-opportunity-07" in the table with the following values
      | name       | opportunity-edited-01 |
      | close_date | 9/11/2019             |
      | stage      | Value Proposition     |
    And I click "Save" button after edit the opportunity table
    Then I validate the name "opportunity-edited-01" is in the "Opportunities" menu
    And I click the opportunity "opportunity-edited-01" in the table
    And I validate the opportunity view page displays
      | opportunity_name | opportunity-edited-01 |
      | close_date       | 9/11/2019             |
    And I validate the selected stage in the view page is "Value Proposition"
    And I go to opportunity "Details"
    And I validate the values set in the Opportunity Details are
      | Opportunity Name | opportunity-edited-01 |
      | Close Date       | 9/11/2019             |
      | Stage            | Value Proposition     |

  Scenario: Edit Opportunity from Basic Form
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName                    | value                       |
      | text          | Opportunity Name             | auto-opportunity-08         |
      | text          | Close Date                   | 7/12/2019                   |
      | text          | Amount                       | 55                          |
      | select_option | Stage                        | Prospecting                 |
      | checkbox      | Private                      | select                      |
      | select_option | Type                         | Existing Customer - Upgrade |
      | text_area     | Description                  | Short Description           |
      | text          | Next Step                    | Step 01                     |
      | text_option   | Account Name                 | account01                   |
      | select_option | Lead Source                  | Web                         |
      | text_option   | Primary Campaign             | campaign01                  |
      | text          | Order Number                 | OD0001                      |
      | text          | Main Competitor              | Competitor 01               |
      | text          | Current Generator            | Generator 01                |
      | select_option | Delivery/Installation Status | In progress                 |
      | text          | Tracking Number              | TRACK01                     |
    And I validate the notification message says 'Opportunity "auto-opportunity-08" was created.'
    And I validate the selected stage in the view page is "Prospecting"
    And I click on the "Opportunities" tab
    And I select the opportunity "auto-opportunity-08" and click the "Edit" action
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName                    | value                         |
      | text          | Opportunity Name             | opportunity-edited-02         |
      | text          | Close Date                   | 9/10/2019                     |
      | select_option | Stage                        | Needs Analysis                |
      | checkbox      | Private                      | unselect                      |
      | select_option | Type                         | Existing Customer - Downgrade |
      | text_area     | Description                  | Long Description              |
      | text          | Next Step                    | New Step 02                   |
      | select_option | Lead Source                  | Partner Referral              |
      | text          | Order Number                 | OD00011                       |
      | text          | Main Competitor              | New Competitor 02             |
      | text          | Current Generator            | New Generator 02              |
      | select_option | Delivery/Installation Status | Completed                     |
      | text          | Tracking Number              | TRACK02                       |
    Then I validate the notification message says 'Opportunity "opportunity-edited-02" was saved.'
    And I validate the name "opportunity-edited-02" is in the "Opportunities" menu
    And I validate the opportunity "opportunity-edited-02" is in table and the row has the following values
      | close_date   | 9/10/2019      |
      | account_name | account01      |
      | stage        | Needs Analysis |
    And I click the opportunity "opportunity-edited-02" in the table
    And I validate the opportunity view page displays
      | opportunity_name | opportunity-edited-02 |
      | close_date       | 9/10/2019             |
      | amount           | $55.00         |
    And I validate the selected stage in the view page is "Needs Analysis"
    And I go to opportunity "Details"
    And I validate the values set in the Opportunity Details are
      | Opportunity Name             | opportunity-edited-02         |
      | Private                      | unselect                      |
      | Close Date                   | 9/10/2019                     |
      | Amount                       | $55.00                         |
      | Stage                        | Needs Analysis                |
      | Type                         | Existing Customer - Downgrade |
      | Description                  | Long Description              |
      | Next Step                    | New Step 02                   |
      | Probability                  | 20%                           |
      | Lead Source                  | Partner Referral              |
      | Order Number                 | OD00011                       |
      | Main Competitor              | New Competitor 02             |
      | Current Generator            | New Generator 02              |
      | Delivery/Installation Status | Completed                     |
      | Tracking Number              | TRACK02                       |
