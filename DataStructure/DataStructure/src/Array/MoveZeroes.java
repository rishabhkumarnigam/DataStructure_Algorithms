package Array;

import java.util.Arrays;

public class MoveZeroes {
  public static void main(String[] args) {
    int[] a = { 0, 0, 0, 0, 1 };
    System.out.println(Arrays.toString(moveZero(a)));
  }

  public static int[] moveZero(int[] arr) {

    int arr1[]=arr;
    int counter=0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr1[counter++]=arr[i];
      }
    }

    while (counter<arr.length){
      arr1[counter++]=0;
    }

    return arr1;
  }
}
