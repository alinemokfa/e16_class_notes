require( 'pg' )

class PizzaOrder

  attr_accessor :first_name, :last_name, :topping, :quantity
  attr_reader :id

  def initialize( options )
    @first_name = options['first_name']
    @last_name = options['last_name']
    @topping = options['topping']
    @quantity = options['quantity'].to_i
    @id = options['id'].to_i if options['id']
  end

  def save()
    db = PG.connect( { dbname: 'pizza_shop', host: 'localhost' } )
    sql = "INSERT INTO pizza_orders
      (
        first_name, 
        last_name, 
        topping, 
        quantity 
      )
      VALUES
      (
      $1,$2,$3,$4
      )
      RETURNING id"
    values = [@first_name, @last_name, @topping, @quantity]
    db.prepare("save", sql)
    @id = db.exec_prepared("save", values)[0]["id"].to_i
    db.close
  end

  def update()
    db = PG.connect( { dbname: 'pizza_shop', host: 'localhost' } )
    sql = "UPDATE pizza_orders
      SET 
      (
        first_name, 
        last_name, 
        topping, 
        quantity
      ) =
      (
        $1, $2, $3, $4
      )
      WHERE id = $5"
    values = [@first_name, @last_name, @topping, @quantity, @id]
    db.prepare("update", sql)
    db.exec_prepared("update", values)
    db.close
  end

  def delete()
    db = PG.connect( { dbname: 'pizza_shop', host: 'localhost' } )
    sql =  "DELETE FROM pizza_orders 
      WHERE id = $1"
    values = [@id]
    db.prepare("delete", sql)
    db.exec_prepared("delete", values)
    db.close
  end

  def PizzaOrder.delete_all()
    db = PG.connect( { dbname: 'pizza_shop', host: 'localhost' } )
    sql = "DELETE FROM pizza_orders"
    values = []
    db.prepare("delete_all", sql)
    db.exec_prepared("delete_all", values)
    db.close
  end

  def PizzaOrder.all()
    db = PG.connect( { dbname: 'pizza_shop', host: 'localhost' } )
    sql = "SELECT * FROM pizza_orders"
    values = []
    db.prepare("all", sql)
    orders = db.exec_prepared("all", values)
    db.close
    return orders.map { |order_hash| PizzaOrder.new( order_hash ) }
  end

end
