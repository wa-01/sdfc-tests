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
    Then I verify the following error message in the form: "These required fields must be completed: Close Date, Opportunity Name, Stage"
    And I verify that the following fields are required in the form:
      | Opportunity Name |
      | Close Date       |
      | Stage            |

  Scenario: Create Opportunity with only required fields
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName        | value               |
      | text          | Opportunity Name | auto-opportunity-00 |
      | text          | Close Date       | 1/1/2020            |
      | select_option | Stage            | Prospecting         |
    Then I validate the notification message says 'Opportunity "auto-opportunity-00" was created.'
    And I validate the opportunity view page displays
      | opportunity_name | auto-opportunity-00 |
      | close_date       | 1/1/2020            |
    And I validate the selected stage in the view page is "Prospecting"
    And I go to opportunity "Details"
    And I validate the values set in the Opportunity Details are
      | Opportunity Name | auto-opportunity-00 |
      | Close Date       | 1/1/2020            |
      | Stage            | Prospecting         |
    And I click on the "Opportunities" tab
    And I validate the name "auto-opportunity-00" is in the "Opportunities" menu
    And I validate the opportunity "auto-opportunity-00" is in table and the row has the following values
      | close_date | 1/1/2020    |
      | stage      | Prospecting |

  Scenario Outline: Create multiple Opportunity items
    When I click on the Add New Opportunity button
    And I fill the create form and click the "Save" button
      | fieldType     | fieldName                    | value               |
      | text          | Opportunity Name             | <name>              |
      | text          | Close Date                   | <close_date>        |
      | text          | Amount                       | <amount>            |
      | select_option | Stage                        | <stage>             |
      | checkbox      | Private                      | <private>           |
      | select_option | Type                         | <type>              |
      | text_area     | Description                  | <description>       |
      | text          | Next Step                    | <next_step>         |
      | text_option   | Account Name                 | <account_name>      |
      | select_option | Lead Source                  | <lead_source>       |
      | text_option   | Primary Campaign             | <primary_campaign>  |
      | text          | Order Number                 | <order_number>      |
      | text          | Main Competitor              | <main_competitor>   |
      | text          | Current Generator            | <current_generator> |
      | select_option | Delivery/Installation Status | <delivery_status>   |
      | text          | Tracking Number              | <tracking_number>   |
    Then I validate the notification message says 'Opportunity "<name>" was created.'
    And I validate the opportunity view page displays
      | opportunity_name | <name>       |
      | close_date       | <close_date> |
      | amount           | $<amount>    |
    And I validate the selected stage in the view page is "<stage>"
    And I go to opportunity "Details"
    And I validate the values set in the Opportunity Details are
      | Opportunity Name             | <name>              |
      | Private                      | <private>           |
      | Close Date                   | <close_date>        |
      | Amount                       | $<amount>           |
      | Stage                        | <stage>             |
      | Type                         | <type>              |
      | Description                  | <description>       |
      | Next Step                    | <next_step>         |
      | Account Name                 | <account_name>      |
      | Lead Source                  | <lead_source>       |
      | Primary Campaign Source      | <primary_campaign>  |
      | Order Number                 | <order_number>      |
      | Main Competitor              | <main_competitor>   |
      | Current Generator            | <current_generator> |
      | Delivery/Installation Status | <delivery_status>   |
      | Tracking Number              | <tracking_number>   |
    And I click on the "Opportunities" tab
    And I validate the name "<name>" is in the "Opportunities" menu
    And I validate the opportunity "<name>" is in table and the row has the following values
      | close_date   | <close_date>   |
      | account_name | <account_name> |
      | stage        | <stage>        |
    Examples:
      | name                | close_date | stage               | private  | amount | description      | type                          | next_step    | account_name | lead_source    | primary_campaign | order_number | main_competitor | current_generator | delivery_status | tracking_number |
      | auto-opportunity-01 | 7/12/2019  | Prospecting         | select   | 15.00  | A description 01 | Existing Customer - Downgrade | Next step 01 | account01    | Web            | campaign01       | ORD001       | Competitor 01   | Generator 01      | In progress     | TRACK001        |
      | auto-opportunity-02 | 8/11/2019  | Needs Analysis      | unselect | 17.00  | A description 02 | Existing Customer - Upgrade   | Next step 02 | account01    | Purchased List | campaign01       | ORD002       | Competitor 02   | Generator 02      | Yet to begin    | TRACK002        |
      | auto-opportunity-03 | 15/10/2019 | Perception Analysis | select   | 25.5   | A description 03 | New Customer                  | Next step 03 | account01    | Phone Inquiry  | campaign01       | ORD003       | Competitor 03   | Generator 03      | Completed       | TRACK003        |