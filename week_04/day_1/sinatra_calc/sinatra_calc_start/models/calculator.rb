class Calculator

  def initialize(num1, num2)
    @num1 = num1
    @num2 = num2
  end

  def add
    return @num1 + @num2
  end

  def subtract
    return @num1 - @num2
  end

  def multiply
    return @num1 * @num2 
  end

  def divide
    return @num1 / @num2
  end

end