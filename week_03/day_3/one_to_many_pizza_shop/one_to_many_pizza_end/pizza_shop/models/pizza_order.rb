require_relative('../db/sql_runner.rb')
require_relative('./customer.rb')

class PizzaOrder

  attr_reader :id
  attr_accessor :topping, :quantity

  def initialize(options)
    @topping = options['topping']
    @quantity = options['quantity'].to_i
    @id = options['id'].to_i if options['id']
    @customer_id = options['customer_id'].to_i
  end

  def customer()
    sql = "SELECT * FROM customers 
    WHERE id = $1"
    values = [@customer_id]
    results = SqlRunner.run(sql, values)
    customer_hash = results[0]
    customer = Customer.new(customer_hash)
    return customer
  end

  def save()
    sql = "
    INSERT INTO pizza_orders (
      customer_id,
      topping,
      quantity
    ) 
    VALUES 
    (
      $1, $2, $3
    )
    RETURNING id"
    values = [@customer_id, @topping, @quantity]
    @id = SqlRunner.run(sql, values)[0]['id'].to_i
  end

  def update()
    sql = "
    UPDATE pizza_orders SET (
      customer_id,
      topping,
      quantity
    ) = 
    (
      $1, $2, $3
    )
    WHERE id = $4"
    values = [@customer_id, @topping, @quantity, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM pizza_orders 
    WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def self.all()
    sql = "SELECT * FROM pizza_orders"
    values = []
    order_hashes = SqlRunner.run(sql, values)
    orders = order_hashes.map { |order| PizzaOrder.new( order ) }
    return orders
  end

  def self.find(id)
    sql = "SELECT *
    FROM pizza_orders 
    WHERE id = $1"
    values = [id]
    results = SqlRunner.run(sql, values)
    order_hash = results.first
    order = PizzaOrder.new(order_hash)
    return order
  end

  def self.delete_all()
    sql = "DELETE FROM pizza_orders"
    values = []
    SqlRunner.run(sql, values)
  end

end
