package hashTable;

import java.util.HashSet;
import java.util.Set;


//Given an array=[2,5,1,2,3,5,1,2,4]
//returns 2

//Given an array=[2,5,1,1,2,3,5,1,2,4]
//returns 1

//Given an array=[2,3,4,5]
//returns undefined

public class FirstRecurringNumber {

  public static void main(String[] args) {
    System.out.println(getRecurring(new int[]{2,5,1,2,3,5,1,2,4}));
    System.out.println(getRecurring(new int[]{2,5,1,1,2,3,5,1,2,4}));
    System.out.println(getRecurring(new int[]{2,3,4,5}));
  }

  public static int getRecurring(int[] arr) {

    Set<Integer> arraySet = new HashSet<>(arr.length);
    for (int a : arr) {
      if (arraySet.contains(a))
        return a;
      arraySet.add(a);
    }
    return -1;
  }
}


