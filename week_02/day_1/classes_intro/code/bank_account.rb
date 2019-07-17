class BankAccount
  attr_accessor :name, :value, :type
  def initialize(name,value,type)
    @name = name
    @type = type
    @value = value
  end

  def pay_in(value)
    @value += value
  end

  def pay_monthly_fee
   @value -= 10 if @type == 'personal'
   @value -= 50 if @type == 'business'
  end

end

