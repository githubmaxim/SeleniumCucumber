Feature: Test Website "Areal.me"

#  Не используем для открытия страниц "Background", т.к. этот механизм также как и @Before, при
#  многопоточном запуске откроет не 2 виндовс окна (по одному для каждого теста), а 4
#  Background: Open Website
#    Given Open Website "https://www.arealme.com/typing-test/ru/#google_vignette"

  Scenario: The bot enters words itself
    Given open Webdriver1 for site "https://www.arealme.com/typing-test/ru/#google_vignette"
    When choose test - one minute
    And start the test
    And enter symbols of the line during 1 minute
    And screenshot of result  for 1 minute
    Then check that the quantity of symbols more than 900
#    close Webdriver implemented in separate class with @After annotation
#    And close Webdriver1

  Scenario: The bot two enters words itself  №2
    Given open Webdriver2 for site "https://www.arealme.com/typing-test/ru/#google_vignette"
#    The next point is not necessary because We are already on the page where the two-minute cycle is selected
#    Given choose test - 2 minute
    When start the test №2
    And enter symbols of the line during 2 minute  №2
    And screenshot of result for 2 minute
    Then check that the quantity of symbols more than 900  №2
#    close Webdriver implemented in separate class with @After annotation
#    And close Webdriver2
