require('pry')
require_relative('models/pizza_order.rb')
require_relative('models/customer.rb')

PizzaOrder.delete_all()
Customer.delete_all()

customer_1 = Customer.new({'name' => 'Jarrod'})

customer_1.save()

order_1 = PizzaOrder.new({
  'topping' => 'pepperoni',
  'quantity' => '2',
  'customer_id' => customer_1.id
})
order_1.save()

order_2 = PizzaOrder.new({
  'topping' => 'margherita',
  'quantity' => '1',
  'customer_id' => customer_1.id
})
order_2.save()

binding.pry
nil
