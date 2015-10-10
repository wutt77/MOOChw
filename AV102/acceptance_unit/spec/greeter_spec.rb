require 'greeter'

describe 'Greeter' do
  it 'should respond to greeting' do
    Greeter.new.should respond_to :greet  
  end
  it 'should respond with "hello" by default' do
    Greeter.new.greet.should eq "Hello"
  end
end
