@validation
Feature: Input field validations

  Scenario: Validate how many characters can by typed into an input field
    Given the user is on my dummy website
#    When the user types in "123456789" into input field
#    |A|B|C|D|E|
#    |1|2|3|4|5|
    #when selenium types in only that number of characters that is possible manually
    When user types in values into input field
      | value     | expectedAppearingValue |
      | 123456789 | 12345                  |
      | abcdefg   | abcde                  |
    #when selenium types in more characters than manually can be typed in
#    Then validate that "5" characters can be typed into input field