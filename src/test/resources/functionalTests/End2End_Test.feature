Feature: Run basic functional test
Scenario Outline: Check to see if aos application body is not null
Given The selenium setup is complete
When print a simple message "<username>"
And verify the email address
Then aos application body is loaded and not null
And close the web browser
Examples:
	|username|
	|Sandeep|

