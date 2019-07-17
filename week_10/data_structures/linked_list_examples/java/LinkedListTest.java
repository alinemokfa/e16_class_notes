import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTest {
  LinkedList linkedList;
  Node head;

  @Before
  public void before() {
    head = new Node("Test");
    linkedList = new LinkedList(head);
  }

  @Test
  public void initialLengthIs1() {
    assertEquals(1, linkedList.length());
  }

  @Test
  public void canPushNewNode() {
    Node newHead = new Node("New Head");
    linkedList.push(newHead);
    assertEquals(2, linkedList.length());
  }

}
