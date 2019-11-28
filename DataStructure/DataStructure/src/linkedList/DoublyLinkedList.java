package linkedList;

public class DoublyLinkedList<E> {

  private Node<E> head;

  public DoublyLinkedList(Node<E> node) {
    this.head = node;
  }
  public DoublyLinkedList() {
    this.head = null;
  }

  public void append(E item){
    Node<E> newNode=new Node<>(item);
    if(head == null)
    {
      head=newNode;
      return;
    }

    Node<E> currentNode=head;
    while(currentNode.next != null){
      currentNode=currentNode.next;
    }
    newNode.previous=currentNode;
    currentNode.next=newNode;
  }

  public void prepend(E item){
    Node<E> newNode=new Node<>(item);

    head.previous=newNode;
    newNode.next=head;
    head=newNode;
  }

  public void printList(){
    Node temp=head;
    while (temp != null){
      System.out.print(temp.item + " ");
      temp=temp.next;
    }
  }

  static class Node<E>{
    E item;
    Node<E> next;
    Node<E> previous;

    public Node(E item) {
      this.item = item;
      this.next = null;
      this.previous = null;
    }
  }


  public static void main(String[] args) {
    DoublyLinkedList<String> doublyLinkedList=new DoublyLinkedList<>();
    doublyLinkedList.append("b");
    doublyLinkedList.append("c");

    System.out.println("\n After adding to end of list");
    doublyLinkedList.printList();

    doublyLinkedList.prepend("a");
    System.out.println("\n After adding to start of list");
    doublyLinkedList.printList();

  }
}
