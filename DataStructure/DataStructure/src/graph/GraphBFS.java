package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class GraphBFS {

  //its an array of linkedList
  LinkedList<Integer>[] adj;

  private int v;

  public GraphBFS(int v) {
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

  public void bFS(int start) {

    List<Integer> path = new ArrayList<>();

    //to mark all the nodes visited
    boolean[] visited = new boolean[v];

    //to keep the nodes that we have traversed and get back to same node
    Queue<Integer> queue = new LinkedList<>();

    //mark first element as visited and enqueue it
    visited[start] = true;
    queue.add(start);

    while (queue.size() != 0) {

      //deque element from queue
      start = queue.poll();
      path.add(start);

      //take out all the connected nodes from that queue
      ListIterator<Integer> adjacentVertex = adj[start].listIterator();

      //iterate connected nodes and mark them visited
      while (adjacentVertex.hasNext()) {
        final int next = adjacentVertex.next();
        if (visited[next] == false) {
          visited[next] = true;
          queue.add(next);
        }
      }
    }

    System.out.println(path);

  }

  public static void main(String[] args) {
    GraphBFS graphBFS=new GraphBFS(8);
    graphBFS.addEdges(0,1);
    graphBFS.addEdges(0,3);
    graphBFS.addEdges(0,6);
    graphBFS.addEdges(1,4);
    graphBFS.addEdges(1,5);
    graphBFS.addEdges(2,5);
    graphBFS.addEdges(2,7);
    graphBFS.addEdges(3,0);
    graphBFS.addEdges(3,5);
    graphBFS.addEdges(4,6);
    graphBFS.addEdges(4,1);
    graphBFS.addEdges(5,1);
    graphBFS.addEdges(5,3);
    graphBFS.addEdges(5,2);
    graphBFS.addEdges(6,0);
    graphBFS.addEdges(6,4);
    graphBFS.addEdges(7,2);


    graphBFS.bFS(0);

  }

}
