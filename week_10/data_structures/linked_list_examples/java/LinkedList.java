public class LinkedList {
  Node head;

  public LinkedList(Node head) {
    this.head = head;
  }

  public int length() {
    int count = 0;
    Node node = head;

    while (node != null) {
      count++;
      node = node.getNext();
    }
    return count;
  }

  public void push(Node newHead) {
    Node existingHead = head;
    this.head = newHead;
    newHead.setNext(existingHead);
  }

  public String get(int index) {
    if (index == 0) {
      return head.getName();
    }
    Node node = head;
    for (int i = 1; i <= index; i++) {
      node = node.getNext();
    }
    return node.getName();
  }
}
