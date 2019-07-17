import static org.junit.Assert.assertEquals;
import org.junit.*;

public class PersonTest{
  Person person;

  @Before
  public void before() {
    person = new Person("Wilma");
  }

  @Test
  public void hasName(){
    assertEquals( "Wilma", person.getName() );
  }
}
