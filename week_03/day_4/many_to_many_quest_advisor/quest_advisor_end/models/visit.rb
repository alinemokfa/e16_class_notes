require_relative("../db/sql_runner")
require_relative("user")
require_relative("location")

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

  def Visit.all()
    sql = "SELECT * FROM visits"
    values = []
    visit_data = SqlRunner.run(sql, values)
    return Visit.map_items(visit_data)
  end

  def Visit.delete_all()
   sql = "DELETE FROM visits"
   values = []
   SqlRunner.run(sql, values)
  end

  def user()
    sql = "SELECT * 
    FROM users 
    WHERE id = $1"
    values = [@user_id]
    user = SqlRunner.run(sql, values).first
    return User.new(user)
  end  

  def location()
    sql = "SELECT * 
    FROM locations 
    WHERE id = $1"
    values = [@location_id]
    location = SqlRunner.run(sql, values).first
    return Location.new(location)
  end

  def Visit.map_items(visit_data)
    result = visit_data.map { |visit| Visit.new( visit ) }
    return result
  end

end