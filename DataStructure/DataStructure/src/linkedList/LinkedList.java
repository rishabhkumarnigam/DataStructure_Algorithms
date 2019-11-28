package linkedList;

public class LinkedList<E> {

  private Node<E> head;

  public LinkedList(Node<E> head) {
    this.head = head;
  }

  public LinkedList() {
    this.head = null;
  }

  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList();
    linkedList.append("b");
    linkedList.append("c");
    linkedList.append("d");
    linkedList.append("f");
    linkedList.append("g");

    System.out.println("\n After adding to end of list");
    linkedList.printList();

    linkedList.prepend("a");
    System.out.println("\n After adding to start of list");
    linkedList.printList();

    linkedList.insertAfterNth("e", 4);
    System.out.println("\n After adding to nth from start of list");
    linkedList.printList();

    linkedList.remove(2);
    System.out.println("\n After removing to nth from start of list");
    linkedList.printList();

    final Object middle = linkedList.findMiddle();
    System.out.println("\n Middle is " + middle);

    linkedList.reverseLinkedList();
    System.out.println("\n After reversing list");
    linkedList.printList();

  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.item + " ");
      temp = temp.next;
    }
  }

  public void append(E value) {

    final Node<E> newNode = new Node<>(value);
    Node current = head;

    if (current == null) {
      head = newNode;
      return;
    }

    Node next = head.next;
    while (next != null) {
      current = next;
      next = next.next;
    }
    current.next = newNode;
  }

  public void insertAfterNth(E value, int n) {

    final Node<E> newNode = new Node<>(value);
    Node current = head;
    if (current == null) {
      if (n == 0) {
        head = newNode;
      }
      return;
    }

    Node next = head.next;

    for (int i = 0; i < n - 1 && current != null; i++) {
      current = next;
      next = next.next;
    }
    Node tempNode = current.next;
    current.next = newNode;
    newNode.next = tempNode;
  }

  public void remove(int n) {
    Node current = head;
    Node next = head.next;
    for (int i = 0; i < n - 1 && current != null; i++) {
      current = next;
      next = next.next;
    }
    current.next = next.next;
  }

  public void prepend(E value) {
    final Node<E> newNode = new Node<>(value);
    newNode.next = head;
    head = newNode;
  }

  public E findMiddle() {
    if (head == null) {
      return null;
    }
    Node<E> firstPointer = head;
    Node<E> secondPointer = head;

    //checking second.next != null for the condition where length is even
    while (secondPointer != null && secondPointer.next != null) {
      firstPointer = firstPointer.next;
      secondPointer = secondPointer.next.next;
    }
    return firstPointer.item;
  }

  public boolean checkCycleInList(){
    Node<E> slow=head;
    Node<E> fast=head.next;
    while (true){
      if(fast == null || fast.next==null){
        return false;
      }
      else if(fast==slow || fast.next==slow){
        return true;
      }
      else {
        slow=slow.next;
        fast=fast.next.next;
      }
    }
  }

  public void reverseLinkedList(){

    Node previous=null;
    Node current=head;
    Node next=null;

    while(current !=null){
      next=current.next;
      current.next=previous;
      previous=current;
      current=next;
    }
    head=previous;
  }


  static class Node<E> {
    E item;

    Node<E> next;

    public Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }

    public Node(E item) {
      this.item = item;
      this.next = null;
    }
  }
}

