Feature: Create new asset
  Background:
    Given I sign in as "sf_user"

  Scenario Outline: Create Basic Asset
    And I click on the AppLauncher Icon
    And I select the item "Assets"
    And I click on Assets Page "New" button
    And I fill the create form with
      | fieldType   | fieldName      | value             |
      | text        | Asset Name     | <assetName>           |
      | text_option | Account        | test-account-1    |

    When I click the "Save" button on new item Form Page

    Then I verify that the title on "Asset" page is "<assetName>"
    And I verify that "Asset Name" inner form text field is "<assetName>"
    And I verify that "<assetName>" is on dropdown menu of "Assets" tab
    And I click on the AppLauncher Icon
    And I select the item "Assets"
    And I verify that "<assetName>" is on a row in inner Assets table
    Examples:
      | assetName    |
      | test123      |


  Scenario Outline: Edit Asset
    And I click on the AppLauncher Icon
    And I select the item "Assets"
    And I click the edit button for "<actualAssetName>" Asset
    And I add "_edited" text to the following fields in the edit form:
      | fieldName           |
      | Asset Name          |

    When I click the "Save" button on edit item Form Page

    Then I verify that "<expectedAssetName>" is on a row in inner Assets table
    And I click on the "<expectedAssetName>" asset link
    And I verify that the title on "Asset" page is "<expectedAssetName>"
    And I verify that "Asset Name" inner form text field is "<expectedAssetName>"
    Examples:
      | actualAssetName     | expectedAssetName     |
      | test123             | test123_edited        |