import static org.junit.Assert.*;
import org.junit.*;

public class NodeTest {
  Node node;

  @Before
  public void before() {
    node = new Node("Head");
  }

  @Test
  public void hasName() {
    assertEquals("Head", node.getName());
  }

  @Test
  public void nextIsNull() {
    assertNull(node.getNext());
  }

  @Test
  public void canSetName() {
    node.setName("Tail");
    assertEquals("Tail", node.getName());
  }

  @Test
  public void canSetNext() {
    Node next = new Node("Tail");
    node.setNext(next);
    assertNotNull(node.getNext());
  }

  @Test
  public void canGetNext() {
    Node next = new Node("Tail");
    node.setNext(next);
    assertEquals("Tail", node.getNext().getName());
  }

}
