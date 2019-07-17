require_relative("../db/sql_runner")

class User

  attr_reader :id
  attr_accessor :name

  def initialize( options )
    @id = options['id'].to_i
    @name = options['name']
  end

  def save()
    sql = "INSERT INTO users 
    (
      name
    ) 
    VALUES 
    (
      $1
    ) 
    RETURNING id"
    values = [@name]
    user = SqlRunner.run( sql, values ).first
    @id = user['id'].to_i
  end

  def User.all()
    sql = "SELECT * FROM users"
    values = []
    user_data = SqlRunner.run(sql, values)
    return User.map_items(user_data)
  end

  def User.delete_all()
   sql = "DELETE FROM users"
   values = []
   SqlRunner.run(sql, values)
  end

  def locations()
    sql = "SELECT locations.* 
    FROM locations 
    INNER JOIN visits 
    ON visits.location_id = locations.id 
    WHERE user_id = $1"
    values = [@id]
    location_data = SqlRunner.run(sql, values)
    return Location.map_items(location_data)
  end

  def reviews()
    sql = "SELECT locations.*, visits.* 
    FROM locations 
    INNER JOIN visits 
    ON visits.location_id = locations.id 
    WHERE user_id = $1"
    values = [@id]
    results = SqlRunner.run(sql, values)
    return results.map { |result| "#{result['name']}: #{result['review']}" }
  end

  def User.map_items(user_data)
    result = user_data.map { |user| User.new( user ) }
    return result
  end

end