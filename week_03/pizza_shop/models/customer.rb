require ('pg')
require_relative('../db/sql_runner.rb')
require_relative('pizza_order.rb')

class Customer
  attr_reader :id, :name

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @name = options['name']
  end

  def save()
    sql = "
      INSERT INTO customers( name )
      VALUES ( $1 )
      RETURNING *
    "
    values = [@name]
    result = SqlRunner.run(sql, values)
    @id = result[0]['id'].to_i
  end

  def self.all()
    sql = "SELECT * FROM customers"
    values = []
    customers = SqlRunner.run(sql, values)
    customers_as_objects = customers.map {
      |customer| Customer.new(customer)
    }
    return customers_as_objects
  end

  def self.delete_all()
    sql = "DELETE FROM customers"
    values = []
    SqlRunner.run(sql, values)
  end

  def pizza_orders()
    sql = "SELECT * FROM pizza_orders WHERE customer_id = $1"
    values = [@id]
    results = SqlRunner.run(sql, values)
    orders = results.map{ |order| PizzaOrder.new(order) }
    return orders
  end








end
