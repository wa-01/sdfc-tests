Feature: Contactas

  Scenario: Create a Contact
    Given I sign in as "username" user and "password" as password
    And I click on the AppLauncher Icon
    And I select the item "Contacts"
    When I click the new button
    And I set the contact form
      | LastName | MyContact |
    Then I validate the contact label is "MyContact"





    #    test
#  1. Que el contact creado se liste
#  2. entityNameTitle
#  3. Details
#  4. Si esta linkeado a una cuenta se tiene que mostrar en el detail de la cuenta
