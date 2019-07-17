require_relative('../db/sql_runner')

class Customer

  attr_reader :id, :name, :funds

  def initialize(options)
    @id = options['id'].to_i
    @name = options['name']
    @funds = options['funds'].to_f
  end

  def save()
    sql = "INSERT INTO customers 
    (
      name, 
      funds
    ) VALUES 
    (
      $1, $2
    ) RETURNING *"
    values = [@name, @funds]
    customer = SqlRunner.run(sql, values).first
    @id = customer['id'].to_i
  end

  def films()
    sql = "SELECT films.* 
    FROM films 
    INNER JOIN tickets 
    ON tickets.film_id = films.id 
    WHERE tickets.customer_id = $1"
    values = [@id]
    film_data = SqlRunner.run(sql, values)
    return Film.map_items(film_data)
  end

  def number_of_tickets_bought()
    return films().count
  end

  def Customer.all()
    sql = "SELECT * FROM customers"
    values = []
    customer_data = SqlRunner.run(sql, values)
    return Customer.map_items(customer_data)
  end

  def Customer.delete_all()
    sql = "DELETE FROM customers"
    values = []
    SqlRunner.run(sql, values)
  end


  #Helper methods for mapping
  def Customer.map_items(customer_data)
    result = customer_data.map { |customer| Customer.new( customer ) }
    return result
  end

  def self.map_item(customer_data)
    result = Customer.map_items(customer_data)
    return result.first
  end

end