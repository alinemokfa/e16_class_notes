require_relative('../db/sql_runner.rb')
require_relative('./pizza_order.rb')

class Customer

  attr_reader(:id)
  attr_accessor(:name)

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @name = options['name']
  end

  def pizza_orders()
    sql = "SELECT * FROM pizza_orders 
    WHERE customer_id = $1"
    values = [@id]
    order_hashes = SqlRunner.run(sql, values)
    order_objects = order_hashes.map { |order_hash| PizzaOrder.new(order_hash) }
    return order_objects
  end

  def save()
    sql = "INSERT INTO customers 
    (
    name
    ) 
    VALUES 
    (
    $1
    ) 
    RETURNING *"
    values = [@name]
    returned_array = SqlRunner.run(sql, values)
    customer_hash = returned_array[0]
    id_string = customer_hash['id']
    @id = id_string.to_i
  end

  def update()
    sql = "UPDATE customers 
    SET 
    (
      name
    ) = 
    (
      $1
    ) 
    WHERE id = $2"
    values = [@name, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM customers 
    WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def self.all()
    sql = "SELECT * FROM customers"
    values = []
    customer_hashes = SqlRunner.run(sql, values)
    customer_objects = customer_hashes.map{|person| Customer.new(person)}
    return customer_objects
  end

  def self.find(id)
    sql = "SELECT * FROM customers
    WHERE id = $1"
    values = [id]
    results = SqlRunner.run(sql, values)
    customer_hash = results.first
    customer = Customer.new(customer_hash)
    return customer
  end

  def self.delete_all()
    sql = "DELETE FROM customers"
    values = []
    SqlRunner.run(sql, values)
  end


end
