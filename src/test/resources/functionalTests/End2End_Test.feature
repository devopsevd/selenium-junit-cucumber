Feature: Run basic functional test
	Scenario Outline: Check to see if aos application body is not null
		Given The selenium setup is complete
		When user “<username>” is selected
		Then aos application body is loaded and not null
    And close the web browser
  Examples:
		| username |
		| John |