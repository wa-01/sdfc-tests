Feature: Opportunities

  Background:
    Given I sign in as "username" user and "password" as password
    And I click on the AppLauncher Icon
    And I select the item "Opportunities"

  Scenario Outline: Create public/private basic Opportunity
    When I click on the Add New Opportunity button
    And I add the opportunity with
      | name       | <name>       |
      | close_date | <close_date> |
      | stage      | <stage>      |
      | private    | <private>    |
    Then I validate the opportunity is in the table
    And I validate the name <name> is in the recent records list
    And I validate the opportunity view page displays
      | name       | <name>       |
      | close_date | <close_date> |
    And I validate the selected stage in the view page is <stage>
    And I validate the opportunity details has set the values
      | name       | <name>       |
      | close_date | <close_date> |
      | stage      | <stage>      |
      | private    | <private>    |

    Examples:
      | name                | close_date | stage       | private |
      | auto-opportunity-01 | 7/10/2019  | Prospecting | false   |
      | auto-opportunity-02 | 7/11/2019  | Prospecting | true    |
