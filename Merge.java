import java.util.Arrays;
public class Merge{
  public static void mergesort(int[] data) {
    mergesort(data, 0, data.length-1);
  }
  private static void mergesort(int[]data, int start, int end){
    //insertion optimize
    if (data.length <= 35) {
      insertionSort(data,start,end);
    } else {
      int[] left = new int[data.length/2];
      int[] right = new int[data.length-data.length/2];
      for (int i = 0; i < left.length; i++) {
        left[i] = data[i];
      }
      for (int j = 0; j < right.length; j++) {
        right[j] = data[j + data.length/2];
      }
      mergesort(left, 0, left.length-1);
      mergesort(right, 0, right.length-1);
      merge(data,left,right);
    }
  }

  public static void insertionSort(int[] ary, int lo, int hi) {
    //the sort starts at index 1 because it is the sorted side
    for (int i = lo + 1; i < hi + 1; i++) {
      //unsorted is being compared to each value in the sorted side
      int unsorted = ary[i];
      int sorted = i - 1;
      //checks if sorted side is greater than the unsorted value
      while (sorted >= 0 && ary[sorted] > unsorted ) {
        //shifts each value forward to the right if the sorted is greater
        ary[sorted+1] = ary[sorted];
        sorted--;
      }
      //if the while loop is done, means sorted side is sorted and insert the unsorted
      //into where it belongs,
      //the right of the next smallest number
      ary[sorted+1] = unsorted;
    }
  }

  private static void merge(int[] data, int[] left, int[] right) {
    //counters store indices of left and right arrays
    int lc = 0;
    int rc = 0;
    //to fill up the given array
    for (int i = 0; i < data.length; i++) {
      //if left array is finished checking, you just insert the rest of the right array
      if (lc >= left.length) {
        data[i] = right[rc];
        rc++;
      } else
      //if right array is finished checking, you insert the rest of the left array
      if (rc >= right.length) {
        data[i] = left[lc];
        lc++;
      } else
      //if a value on the left is greater than a value on the right, insert that right value and shift to check the next right index
      if (left[lc] > right[rc]) {
        data[i] = right[rc];
        rc++;
      } else
      //if a value on the left is less than or equal a value on the right, insert the left value and shift to check next left index
      if (left[lc] <= right[rc]) {
        data[i] = left[lc];
        lc++;
      }
    }
  }

}
