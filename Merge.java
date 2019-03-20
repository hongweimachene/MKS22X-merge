import java.util.Arrays;
public class Merge{
  public static void mergesort(int[] data) {
    mergesort(data, 0, data.length-1);
  }
  private static void mergesort(int[]data, int start, int end){
    if (start >= end) {
      return;
    }
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

  private static void merge(int[] data, int[] left, int[] right) {
    int lc = 0;
    int rc = 0;
    for (int i = 0; i < data.length; i++) {
      if (lc >= left.length) {
        data[i] = right[rc];
        rc++;
      } else
      if (rc >= right.length) {
        data[i] = left[lc];
        lc++;
      } else
      if (left[lc] > right[rc]) {
        data[i] = right[rc];
        rc++;
      } else
      if (left[lc] <= right[rc]) {
        data[i] = left[lc];
        lc++;
      }
    }
  }

}
