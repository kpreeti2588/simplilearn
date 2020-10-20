Feature: Navigate to Calorie Calculator page and from there Navigate to BMI link, 
and Enter BMI Calculator details, calculate the BMI and get and Verify the BMI Category

Background:
    * The User Launches the Calorie Calculator Page1
    * The User Clicks on BMI Link 

@smoke  
Scenario: Enter Calorie Details
    * The User Provides the age as 45
  #  * user selects the gender as f
  #  And user provides the height as 190
  #  And the user provides the weight as 70
    * user selects the gender as f
    And user provides the heightinch as 6
    And the user provides the weight as 70
    And the user clicks on the Calculate Button
    Then The user is provided with BMI Value and BMI Category
    And the user verifies the BMICategory based on the BMI Value
    
@reg 
Scenario Outline: Enter Calorie Details for multiple data sets
    * The User Provides the age as <age>
  #  * user selects the gender as <sex>
  #  And user provides the height as 190
  #  And the user provides the weight as 70
    * user selects the gender as <sex>
    And user provides the heightinch as <height>
    And the user provides the weight as <weight>
    And the user clicks on the Calculate Button
    Then The user is provided with BMI Value and BMI Category
    And the user verifies the BMICategory based on the BMI Value
Examples: 
   |age|sex|height|weight|
   |35|f|190|100|   
@datadriven  
Examples: 
   |age|sex|height|weight|
   |55|m|150|80|

   