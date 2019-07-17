require_relative("../db/sql_runner")

class Visit

  attr_reader :id
  attr_accessor :user_id, :location_id, :review 

  def initialize( options )
    @id = options['id'].to_i
    @user_id = options['user_id'].to_i
    @location_id = options['location_id'].to_i
    @review = options['review']
  end

  def save()
    sql = "INSERT INTO visits 
    (
      user_id, 
      location_id, 
      review
    )
    VALUES 
    (
      $1, $2, $3
    ) 
    RETURNING id"
    values = [@user_id, @location_id, @review]
    visit = SqlRunner.run( sql,values ).first
    @id = visit['id'].to_i
  end

  def self.all()
    sql = "SELECT * FROM visits"
    values = []
    visits = SqlRunner.run(sql, values)
    result = visits.map { |visit| Visit.new( visit ) }
    return result
  end

  def self.delete_all() 
    sql = "DELETE FROM visits"
    values = []
    SqlRunner.run(sql, values)
  end

end