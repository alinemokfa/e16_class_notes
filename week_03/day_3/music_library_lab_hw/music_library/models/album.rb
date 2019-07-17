require_relative('../db/sql_runner')

class Album

  attr_reader( :id, :name, :artist_id )

  def initialize( options )
    @id = options['id'].to_i
    @name = options['name']
    @artist_id = options['artist_id']
  end

  def save()
    sql = "INSERT INTO albums 
    (
    name,
    artist_id
    ) VALUES 
    (
    $1, $2
    ) 
    RETURNING id"
    values = [@name, @artist_id]
    @id = SqlRunner.run( sql, values )[0]["id"].to_i()
  end

  def artist()
    sql = "SELECT * FROM artists 
    WHERE id = $1"
    values = [@artist_id]
    artist = SqlRunner.run( sql,values )
    result = Artist.new( artist.first )
    return result
  end

  def self.all()
    sql = "SELECT * FROM albums"
    values = []
    albums = SqlRunner.run( sql,values )
    result = albums.map { |album_hash| Album.new( album_hash ) }
    return result
  end

end
