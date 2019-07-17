require ('pg')
require_relative('customer.rb')
require_relative('../db/sql_runner.rb')

class PizzaOrder
  attr_accessor :topping, :quantity
  attr_reader :id, :customer_id

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @topping = options['topping']
    @quantity = options['quantity'].to_i()
    @customer_id = options['customer_id'].to_i()
  end

  def save()
    sql = "
      INSERT INTO pizza_orders
      (
        topping,
        quantity,
        customer_id
      )
      VALUES
      (
        $1, $2, $3
      )
      RETURNING *
    "
    values = [@topping, @quantity, @customer_id]
    result = SqlRunner.run(sql, values)
    @id = result[0]['id'].to_i()
  end

  def self.all()
    sql = "SELECT * FROM pizza_orders"
    values = []
    orders = SqlRunner.run(sql, values)
    orders_as_objects = orders.map{ |order| PizzaOrder.new(order)}
    return orders_as_objects
  end

  def self.delete_all()
    sql = "DELETE FROM pizza_orders"
    values = []
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM pizza_orders WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def update()
    sql = "
      UPDATE pizza_orders
      SET (
        topping,
        quantity,
        customer_id
      ) =
      (
        $1, $2, $3
      ) WHERE id = $4
    "
    values = [ @topping, @quantity, @customer_id, @id]
    SqlRunner.run(sql, values)
  end

  def customer()
    sql = "SELECT * FROM customers WHERE id = $1"
    values = [@customer_id]
    results = SqlRunner.run(sql, values)
    customer_data = results[0]
    customer = Customer.new(customer_data)
    return customer

  end









end
