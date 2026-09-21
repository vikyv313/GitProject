Feature: Login Module

  Scenario Outline: Verifying login with valid credentials
    Given User is on the omrbranch page
    When User perfrom login "<userName>","<password>"
    Then User should verify success message after login "Welcome Greens"

    Examples:
      | userName                       | password      |
      | greenstechchennaiomr@gmail.com | Pl@ywright@26 |
