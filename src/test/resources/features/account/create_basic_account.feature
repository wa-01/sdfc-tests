Feature: Accounts

  Background:
    Given I sign in as "edgariverq@personal.com" user and "EEE199909049qqq" as password
    And I click on the AppLauncher Icon
    And I select the item "Accounts"

  Scenario Outline: Create basic account
    When I click on the Add New Account button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName    | value          |
      | text      | Account Name | <nameaccount1> |
    Then I validate the following success message is displayed 'Account "<nameaccount1>" was created.'
    And I validate the account label is table "<nameaccount1>"
    And I click on "Details" tab
    And I validate the account name is "<nameaccount1>"
    And I click on the AppLauncher Icon
    And I select the item "Accounts"
    And I validate the account "<nameaccount1>" is displayed in accounts table

    Examples:
      | nameaccount1    |
      | AccountTest0223 |

#  Scenario Outline: Create full filled account
#    When I click on the Add New Account button
#    And I fill the create form and click the "Save" button
#      | fieldType     | fieldName        | value         |
#      | text          | Account Name     | <nameaccount2>|
#      | text          | Phone            | <phone>       |
#      | text          | Fax              | <fax>         |
#      | text          | Account Number   |<accountnumber>|
#      | text          | Website          | <website>     |
#      | text          | Account Site     | <AccountSite> |
#      | text          | Ticker Symbol    | <TickerSymbol>|
#      | select_option | Rating           | <rating>      |
#      | select_option | Type             | <type>        |
#      | select_option | Ownership        | <ownership>   |
#      | select_option | Industry         | <industry>    |
#      | text          | Employees        | <Employees>   |
#      | text          | Annual Revenue   | <AnnualRevenue>|
#      | text          | SIC Code         | <SICCode>|
#      | text_option   | Parent Account   | <ParentAccount>|
#    Then I validate the following success message is displayed 'Account "<nameaccount2>" was created.'
#    And I validate the account label is table "<nameaccount2>"
#    And I click on "Details" tab
#    And I validate the account name is "<nameaccount2>"
#    And I click on the AppLauncher Icon
#    And I select the item "Accounts"
#    And I validate the account "<nameaccount2>" is displayed in accounts table
#
#    Examples:
#      | nameaccount2                |phone   |fax   |accountnumber|website|AccountSite|TickerSymbol|rating|type|ownership|industry|Employees|AnnualRevenue|SICCode|ParentAccount|
#      | auto-account-02 |59188888888|59144444444|123456|www.salesforce.com|www.salesforcer.com/accounttest|symbolTicket|Hot|Prospect|Public|Chemicals|15|1000|sdfc01|zzzz|
