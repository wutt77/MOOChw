Feature: greeter says hello

Scenario: greeter says hello

Given a greeter
When I send it a greet message
Then I should see "Hello"
