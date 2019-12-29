package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class GraphDFS {

  //its an array of linkedList
  LinkedList<Integer>[] adj;

  private int v;

  public GraphDFS(int v) {
    this.v = v;
    adj = new LinkedList[v];

    //now initialize the array of linkedList so at each location in an array we will
    //have a new linkedList
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdges(int fromVertex, int toVertex) {
    adj[fromVertex].add(toVertex);
  }

  public void dfs(int start) {

    List<Integer> path = new ArrayList<>();

    //to mark all the nodes visited
    boolean[] visited = new boolean[v];

    //to keep the nodes that we have traversed and get back to same node
    Stack<Integer> stack = new Stack<>();

    //mark first element as visited and enqueue it
    visited[start] = true;
    stack.push(start);

    while (stack.size() != 0) {

      //remove element from stack
      start = stack.pop();
      path.add(start);

      //take out all the connected nodes from that queue
      ListIterator<Integer> adjacentVertex = adj[start].listIterator();

      //iterate connected nodes and mark them visited
      while (adjacentVertex.hasNext()) {
        final int next = adjacentVertex.next();
        if (visited[next] == false) {
          visited[next] = true;
          stack.push(next);
        }
      }
    }

    System.out.println(path);

  }

  public static void main(String[] args) {
    GraphDFS graphDFS=new GraphDFS(8);
    graphDFS.addEdges(0,1);
    graphDFS.addEdges(0,3);
    graphDFS.addEdges(0,6);
    graphDFS.addEdges(1,4);
    graphDFS.addEdges(1,5);
    graphDFS.addEdges(2,5);
    graphDFS.addEdges(2,7);
    graphDFS.addEdges(3,0);
    graphDFS.addEdges(3,5);
    graphDFS.addEdges(4,6);
    graphDFS.addEdges(4,1);
    graphDFS.addEdges(5,1);
    graphDFS.addEdges(5,3);
    graphDFS.addEdges(5,2);
    graphDFS.addEdges(6,0);
    graphDFS.addEdges(6,4);
    graphDFS.addEdges(7,2);


    graphDFS.dfs(0);

  }

}
