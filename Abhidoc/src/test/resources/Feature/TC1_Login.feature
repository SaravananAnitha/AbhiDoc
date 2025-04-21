Feature: Verifying AbhiDoc Login Automation

  Scenario Outline: Verifying login with valid credentials
    Given User is on the AbhiDoc page
    When User login "<UserName>","<Password>"
    Then User should verify success message after login "Welcome Saravanan"

    Examples: 
      | UserName                    | Password  |
      | selvasaravana2020@gmail.com | Saravanan@123 |

 

  Scenario Outline: Verifying login with Invalid credentials
    Given User is on the AbhiDoc page
    When User login "<userName>","<password>"
    Then User should verify error message after login "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName                    | password  |
      | selvasaravana2020@gmail.com | Sana@20122020 |
