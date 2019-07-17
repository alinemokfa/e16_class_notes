require_relative('../db/sql_runner')

class Ticket

  attr_reader :id, :customer_id, :film_id

  def initialize(options)
    @id = options['id'].to_i
    @customer_id = options['customer_id'].to_i
    @film_id = options['film_id'].to_i
  end

  def save
    sql = "INSERT INTO tickets 
    (
      customer_id, 
      film_id
    ) 
    VALUES 
    (
      $1, $2
    ) 
    RETURNING *"
    values = [@customer_id, @film_id]
    ticket = SqlRunner.run(sql, values).first
    @id = ticket['id'].to_i
  end 

  def film
    sql = "SELECT *
    FROM films 
    WHERE films.id = $1"
    values = [@film_id]
    film_data = SqlRunner.run(sql, values)
    film = Film.map_item(film_data)
    return film
  end

  def customer
    sql = "SELECT * 
    FROM customers 
    WHERE customers.id = $1"
    values = [@customer_id]
    customer_data = SqlRunner.run(sql, values)
    customer = Customer.map_item(customer_data)
    return customer
  end

  def self.all()
    sql = "SELECT * FROM tickets"
    values = []
    ticket_data = SqlRunner.run(sql, values)
    return Ticket.map_items(ticket_data)
  end

  def self.delete_all()
    sql = "DELETE FROM tickets"
    values = []
    SqlRunner.run(sql, values)
  end


  #Helper methods for mapping
  def self.map_items(ticket_data)
    result = ticket_data.map { |ticket| Ticket.new( ticket ) }
    return result
  end

  def self.map_item(ticket_data)
    result = Ticket.map_items(ticket_data)
    return result.first
  end

end