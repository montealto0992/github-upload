Feature: Search

  Scenario Outline: Login Valid Users
    Given user is in login page
    When user enters <username> and <password>
    Then  user is navigated to account page

    Examples:
      | username  | password        |
      | mustang02 | gsdfgha_1234!!! |

  Scenario Outline: Login Invalid Users
    Given user is in login page
    When user enters <username> and <password>
    Then  user received error message

    Examples:
      | username  | password        |
      | mustang01 | gsdfgha_123 |

