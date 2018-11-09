Feature: Run basic functional test
Scenario Outline: Check to see if aos application body is not null
Given The selenium setup is complete
When print a simple message "<firstname>" "<lastname>" "<emailid>"
Then verify the email address
Then aos application body is loaded and not null
And close the web browser
Examples:
	|firstname| |lastname| |emailid          |
	|Amneet   | |Singh   | |am.singh@test.com|
	|Balaji   | |Krish   | |ba.krish@test.com|
	|Pushpn   | |Sahuu   | |pu.sahuu@test.com|

