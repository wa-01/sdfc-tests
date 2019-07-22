Feature: Opportunities

  Background:
    Given I sign in as "username" user and "password" as password
    And I click on the AppLauncher Icon
    And I select the item "Opportunities"
    And I click on the Add New Opportunity button
    And I add the opportunity with
      | name       | auto-opportunity-03 |
      | close_date | 7/11/2019           |
      | stage      | Prospecting         |

  Scenario Outline: Edit an Opportunity from the main table
    When I edited the opportunity through the table with
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
      | name                       | close_date | stage             | private |
      | auto-opportunity-03-edited | 7/10/2020  | Value Proposition | true    |

  Scenario: Delete an Opportunity
    When I click the "Delete" option in the actions button for "auto-opportunity-03-edited"
    And I click the "Delete" button in the dialog
    Then I validate the "auto-opportunity-03-edited" is not in the table
    And I validate the "auto-opportunity-03-edited" is not in the recent records list