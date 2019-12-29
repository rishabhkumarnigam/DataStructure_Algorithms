package tree;

public class BinarySearchTree {

  //          9
  //    4            20
  //  1   6       15    170

  private Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();

    bst.insert(9);
    bst.insert(4);
    bst.insert(20);
    bst.insert(1);
    bst.insert(15);
    bst.insert(6);
    bst.insert(170);

    System.out.println(bst.lookup(170));
    System.out.println(bst.lookup(1));
    System.out.println(bst.lookup(4));
    System.out.println(bst.lookup(1701));
  }

  //here while moving tree and adding node doesn't change the pointer as we are using
  //recursion and only that part is being moved
  public Node insertionUsingRecursion(Node root, int item) {

    if (root == null) {
      root = new Node(item);
      return root;
    }

    if (root.item > item)
      insertionUsingRecursion(root.left, item);

    else if (root.item < item)
      insertionUsingRecursion(root.right, item);

    return root;
  }

  public void insert(int item) {

    Node tempNode = new Node(item);

    if (root == null) {
      root = tempNode;
      return;
    }

    Node tempRoot = root;

    while (tempRoot != null) {

      if (tempRoot.item > item) {
        if (tempRoot.left == null) {
          tempRoot.left = tempNode;
        } else {
          tempRoot = tempRoot.left;
        }
      } else if (tempRoot.item < item) {
        if (tempRoot.right == null) {
          tempRoot.right = tempNode;
        } else {
          tempRoot = tempRoot.right;
        }
      } else {
        return;
      }
    }
  }

  public boolean lookup(int item) {

    if (root == null) {
      return false;
    }

    Node tempRoot = root;
    while (tempRoot != null) {
      if (tempRoot.item < item) {
        tempRoot = tempRoot.right;
      } else if (tempRoot.item > item) {
        tempRoot = tempRoot.left;
      } else {
        return true;
      }
    }
    return false;
  }

  public boolean lookupUsingRecursion(Node node, int item) {

    if (node == null) {
      return false;
    }

    if (node.item < item) {
      lookupUsingRecursion(node.right, item);
    } else if (node.item > item) {
      lookupUsingRecursion(node.left, item);
    } else
      return node.item == item;
    return false;
  }

  static class Node {
    int item;

    Node left;

    Node right;

    public Node(int item) {
      this.item = item;
      this.left = null;
      this.right = null;
    }
  }
}
