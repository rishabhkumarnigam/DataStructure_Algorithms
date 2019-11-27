package Array;

import java.util.Arrays;

public class RotateArray {
  public static void main(String[] args) {

    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
    int rotation = 3;
    while (rotation > 0) {
      arr = rotateMyArray(arr);
      rotation--;
    }
    System.out.println(Arrays.toString(arr));
  }

  //complexity O(nXk)
  //Space complexity(1)
  private static int[] rotateMyArray(int[] arr) {
    int lastNode = arr[arr.length - 1];
    int i = arr.length - 1;
    for (; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[i] = lastNode;
    return arr;
  }

  //Complexity of O(N)
  //Space complexity O(N)
  public void rotate(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = a[i];
    }
  }

  //Complexity of O(N)
  //Space Complexity of O(1)
  public void rotate3(int[] nums, int k) {


  }
  }


