package queue;

import java.util.Stack;

public class QueueUsingStack {
  /**
   * Initialize your data structure here.
   */

  private Stack<Integer> enqueStack;
  private Stack<Integer> dequeStack;

  public QueueUsingStack() {
    this.enqueStack = new Stack();
    this.dequeStack = new Stack();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {

   enqueStack.push(x);
  }

  /**
   * Here we have transferred the element to empty stack and removed the top but during this process
   * stack is in reverse direction, so we have reversed it again
   */
  public int pop() {

    if(dequeStack.empty()){
      while(!enqueStack.empty()){
        dequeStack.push(enqueStack.pop());
      }
    }

  return   dequeStack.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {

    if(dequeStack.empty() && dequeStack.empty()){
      return -1;
    }

    if(dequeStack.empty()){
      while(!enqueStack.empty()){
        dequeStack.push(enqueStack.pop());
      }
    }

    return   dequeStack.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {

    return (dequeStack.empty() && enqueStack.empty());
  }

  //stack in java pushes from back and removes from back
  public static void main(String[] args) {


    QueueUsingStack queueUsingStack=new QueueUsingStack();
    queueUsingStack.push(1);
    queueUsingStack.push(2);
    queueUsingStack.push(3);
    queueUsingStack.push(4);
    queueUsingStack.push(5);

    System.out.println(queueUsingStack.peek());

    System.out.println(queueUsingStack.pop());
    System.out.println(queueUsingStack.pop());
    System.out.println(queueUsingStack.pop());

    System.out.println(queueUsingStack.pop());
    System.out.println(queueUsingStack.peek());
  }
}
