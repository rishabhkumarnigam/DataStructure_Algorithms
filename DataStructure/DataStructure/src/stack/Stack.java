package stack;

public class Stack<E> {

  private Node<E> head;

  public Stack() {
    this.head = null;
  }

  public static void main(String[] args) {

    Stack<String> stackOfBrowserHistory = new Stack<>();
    stackOfBrowserHistory.push("google");
    stackOfBrowserHistory.push("udemy");
    stackOfBrowserHistory.push("discord");
    stackOfBrowserHistory.push("youtube");

    System.out.println("\n Printing stackOfBrowserHistory after pushing");
    stackOfBrowserHistory.printList();

    stackOfBrowserHistory.pop();
    System.out.println("\n Printing stackOfBrowserHistory after pop");
    stackOfBrowserHistory.printList();

    stackOfBrowserHistory.pop();
    System.out.println("\n Printing stackOfBrowserHistory after pop");
    stackOfBrowserHistory.printList();

    System.out.println("\n Peeping stackOfBrowserHistory " + stackOfBrowserHistory.peep());
  }

  //add to top
  public void push(E item) {

    Node<E> newNode = new Node<>(item);
    if (head == null) {
      head = newNode;
      return;
    }
    newNode.next = head;
    head = newNode;
  }

  //remove from top
  public void pop() {

    if (head == null) {
      return;
    }
    head = head.next;
  }

  public E peep() {
    if (head == null) {
      return null;
    }
    return head.item;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.item + " ");
      temp = temp.next;
    }
  }

  static class Node<E> {
    E item;

    Node<E> next;

    public Node(E item) {
      this.item = item;
      this.next = null;
    }
  }
}
