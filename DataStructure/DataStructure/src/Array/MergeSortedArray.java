package Array;

import java.util.Arrays;
import java.util.stream.Stream;

//[0,3,4,31] [4,6,30]
//[0,3,4,4,6,30,31]
public class MergeSortedArray {

  public static void main(String[] args) {
    int[] arr1={0,3,4,31};
    int[] arr2={4,6,30};

     int[] ints = merge1(arr1, arr2);

    Arrays.stream(ints).forEach(a->System.out.print(a+" "));

  }

  private static int[] merge1(int arr1[],int arr2[]){
    //check

    if(arr1.length==0)
      return arr2;
    if(arr2.length==0)
      return arr1;





    int[] mergeArr=new int[arr1.length+arr2.length];

    int i=0,j=0,k=0;

    while(i<arr1.length && j<arr2.length){
      if(arr1[i] < arr2[j]){
        mergeArr[k++]=arr1[i++];
      }
      else if(arr1[i] > arr2[j]){
        mergeArr[k++]=arr2[j++];
      }
      else{
        mergeArr[k++]=arr1[i++];
        mergeArr[k++]=arr2[j++];
      }
    }

    if(i==arr1.length){
      for(;j<arr2.length;j++,k++){
        mergeArr[k]=arr2[j];
      }
    }
    else {
      for(;i<arr1.length;i++,k++){
        mergeArr[k]=arr1[i];
      }
    }


    return mergeArr;
  }


}
