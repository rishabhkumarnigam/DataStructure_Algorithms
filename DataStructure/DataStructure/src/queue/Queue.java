package queue;

import stack.Stack;

public class Queue<E> {

  private Node<E> first;
  private Node<E> last;

  public Queue() {
    this.first = null;
    this.last = null;
  }

  static class Node<E> {
    E item;

    Node<E> next;

    public Node(E item) {
      this.item = item;
      this.next = null;
    }
  }

  //remove from front
  public void deQueue(){
    if (first == null) {
      return;
    }
    first = first.next;
  }

  //add to last
  public void enQueue(E item){

    Node<E> newNode=new Node<>(item);
    if(first==null){
      first=newNode;
      last=newNode;
      return;
    }
    //here we are pointing next of last node to new node
    last.next=newNode;
    //changing last node to new node now
    last=newNode;
  }

  public void printList() {
    Node temp = first;
    while (temp != null) {
      System.out.print(temp.item + " ");
      temp = temp.next;
    }
  }

  public E peep(){
    if(first ==null){
      return null;
    }
   return first.item;
  }

  public static void main(String[] args) {
    Queue<String> queueOfBookingTicket=new Queue<>();

    queueOfBookingTicket.enQueue("Ram");
    queueOfBookingTicket.enQueue("Sita");
    queueOfBookingTicket.enQueue("Shyam");

    System.out.println("\n Queue after enqueue");
    queueOfBookingTicket.printList();

    queueOfBookingTicket.deQueue();
    System.out.println("\n Queue after dequeue");
    queueOfBookingTicket.printList();

    System.out.println("\n seeing who is on top "+queueOfBookingTicket.peep());
  }
}
