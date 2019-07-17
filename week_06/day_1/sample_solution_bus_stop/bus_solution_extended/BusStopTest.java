import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusStopTest{
  BusStop busStop;
  Person person;
  Bus bus;

  @Before
  public void before() {
    busStop = new BusStop("Leith Walk");
    person = new Person("Wilma");
    bus = new Bus(22, "Gyle Centre", "Ocean Terminal", 25);
  }

  @Test
  public void busStopHasLocation() {
    assertEquals("Leith Walk", busStop.getLocation());
  }

  @Test
  public void busStartsWithNoPeople() {
    assertEquals(0, busStop.personCount());
  }

  @Test
  public void canAddPersonToBusStop() {
    busStop.addPerson(person);
    assertEquals(1, busStop.personCount());
  }

  @Test
  public void busCanTakePassengersFromStop() {
    busStop.addPerson(person);
    busStop.addPerson(person);
    busStop.stopBus(bus);
    assertEquals(0, busStop.personCount());
  }
}
