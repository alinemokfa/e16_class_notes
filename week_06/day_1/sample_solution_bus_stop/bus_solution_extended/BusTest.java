import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusTest{
  Bus bus;
  Person person;

  @Before
  public void before() {
    bus = new Bus(22, "Gyle Centre", "Ocean Terminal", 50);
    person = new Person("Betty");
  }

  @Test
  public void hasRouteNumber(){
    assertEquals( 22, bus.getRouteNumber() );
  }

  @Test
  public void hasStart(){
    assertEquals( "Gyle Centre", bus.getStart() );
  }

  @Test
  public void hasDestination(){
    assertEquals( "Ocean Terminal", bus.getDestination() );
  }

  @Test
  public void hasCapacity(){
    assertEquals( 50, bus.getCapacity() );
  }

  @Test
  public void busStartsWithNoPassengers() {
    assertEquals(0, bus.passengerCount());
  }

  @Test
  public void canAddPassenger() {
    bus.addPassenger(person);
    assertEquals(1, bus.passengerCount());
  }

  @Test
  public void isFullReturnsFalse() {
    bus.addPassenger(person);
    assertEquals(false, bus.isFull());
  }

  @Test
  public void isFullReturnsTrue() {
    for (int i = 0; i < bus.getCapacity(); i++) {
      bus.addPassenger(person);
    }
    assertEquals(true, bus.isFull());
  }

  @Test
  public void cannotAddPassengerIfBusIsFull() {
    int capacity = bus.getCapacity();
    for (int i = 0; i < capacity; i++) {
      bus.addPassenger(person);
    }
    bus.addPassenger(person);
    assertEquals(true, bus.isFull());
    assertEquals(capacity, bus.passengerCount());
  }
}
