package arrayExample;

public class MaximumSubArray {

 /* Input: [-2,1,-3,4,-1,2,1,-5,4],
  Output: 6
  Explanation: [4,-1,2,1] has the largest sum = 6.*/

  public static void main(String[] args) {
    int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    System.out.println(maxSubArray(arr));
  }

  public static int maxSubArray(int[] nums) {

    int currentSum = nums[0];
    int globalSum = nums[0];

    for (int i = 1; i < nums.length; i++) {

      //if the sum that we have found after adding previous(i.e currentSum) is bigger then
      //take that or else if not then take the number at which pointer is
      currentSum = Math.max(nums[i], currentSum + nums[i]);

      //now update the globalSum after comaparing with current sum
      if (currentSum > globalSum)
        globalSum = currentSum;
    }
    return globalSum;
  }
}

