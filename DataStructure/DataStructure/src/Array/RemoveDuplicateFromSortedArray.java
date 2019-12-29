package Array;

// input [1,1,2]
// output [1,2]

// input [0,0,1,1,1,2,2,3,3,4]
// output [0, 1, 2, 3, 4]

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

  int[] nums;

  public static void main(String[] args) {
    RemoveDuplicateFromSortedArray removeDuplicateFromSortedArray = new RemoveDuplicateFromSortedArray();
    removeDuplicateFromSortedArray.nums = new int[] { 0,0,1,1,1,2,2,3,3,4 };
    int length = removeDuplicateFromSortedArray.removeDuplicates(removeDuplicateFromSortedArray.nums);
    for (int i = 0; i < length; i++) {
      System.out.println(removeDuplicateFromSortedArray.nums[i] + " ");
    }
  }

  public int removeDuplicates() {
    int duplicate = 0;
    for (int i = 0; i < nums.length - 1-duplicate; i++) {
      while (nums[i] == nums[i + 1]) {
        nums = shiftToEnd(nums, i);
        duplicate++;
      }
    }
    return nums.length-duplicate;
  }

  public int[] shiftToEnd(int[] arr, int n) {
    int nu = arr[n];
    for (int i = n; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = nu;
    return arr;
  }

  public int removeDuplicates(int[] nums) {

    int duplicate = 0;
    for (int i = 0; i < nums.length - 1-duplicate; i++){
      while (nums[i]==nums[i+1]){
        nums[i+1]=nums[i+2];
        i++;duplicate++;

      }
    }

    System.out.println(Arrays.toString(nums));

    return 0;
  }

}
