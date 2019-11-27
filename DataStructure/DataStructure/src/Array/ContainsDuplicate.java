package Array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  //O(n^2)
  //as n(n+1)/2
  public static boolean containsDuplicate1(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }

    return false;
  }

  //O(n)
  public static boolean containsDuplicate2(int[] nums) {
    Set<Integer> s = new HashSet<>();
    for (Integer n : nums) {
      if (s.contains(n))
        return true;
      s.add(n);
    }
    return false;
  }

  //we can also sort the array first and then check if the element next it is same
  //for sorting we will take logn time and for checking we will take n so it will be nlogn
  //faster than first approach

  public static void main(String[] args) {

    System.out.println(containsDuplicate2(new int[] { 1, 2, 3, 1 }));
    System.out.println(containsDuplicate2(new int[] { 1, 2, 3, 4 }));
  }
}
