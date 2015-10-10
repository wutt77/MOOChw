require 'greeter'

Given(/^a greeter$/) do
  #pending # Write code here that turns the phrase above into concrete actions
  @greeter = Greeter.new
  end

When(/^I send it a greet message$/) do
  #pending # Write code here that turns the phrase above into concrete actions
  @message = @greeter.greet
end

Then(/^I should see "([^"]*)"$/) do |greeting|
  #pending # Write code here that turns the phrase above into concrete actions
  @message.should == greeting
end
