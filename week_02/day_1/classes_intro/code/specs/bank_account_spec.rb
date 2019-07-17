require('minitest/autorun')
require_relative('../bank_account')

class TestBankAccount < MiniTest::Test
  def test_account_name
   account = BankAccount.new('john', 5000, 'business')
   assert_equal('jay',account.name)
  end

  def test_account_value
   account = BankAccount.new('john', 5000, 'business')
   assert_equal(5000,account.value)
  end

  def test_account_type
   account = BankAccount.new('john', 5000, 'business')
   assert_equal('business',account.type)
  end

  def test_set_account_name
    account = BankAccount.new('john', 5000, 'business')
    account.name ='Valerie'
    assert_equal('Valerie',account.name)
  end


  def test_set_account_value
    account = BankAccount.new('john', 5000, 'business')
    account.value = 10000
    assert_equal(10000,account.value)
  end


  def test_set_account_type
    account = BankAccount.new('john', 5000, 'business')
    account.type ='personal'
    assert_equal('personal',account.type)
  end

  def test_pay_into_account
   account = BankAccount.new('john', 5000, 'business')
   account.pay_in(1000)
   assert_equal(6000, account.value)
  end

  def test_monthly_fee_business
    account = BankAccount.new('john', 5000, 'business')
    account.pay_monthly_fee
    assert_equal(4950, account.value)
  end

  def test_monthly_fee_personal
    account = BankAccount.new('darren', 5000, 'personal')
    account.pay_monthly_fee
    assert_equal(4990, account.value)
  end
end
