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
    for (int i = 0; i < data.length; i++) {
      if (i < data.length/2) {
        left[i] = data[i];
      } else {
        right[i] = data[i];
      }
    }
    mergesort(left, start, left.length-1);
    mergesort(right, left.length, end);
    merge(data,left,right);
  }

  private static void merge(int[] data, int[] left, int[] right) {
    int lc = 0;
    int rc = 0;
    int i= 0;
    while (lc < left.length && rc < right.length) {
      if (left[lc] > right[rc]) {
        data[i] = right[rc];
        rc++;
        i++;
      }
      if (left[lc] <= right[rc]) {
        data[i] = left[lc];
        lc++;
        i++;
      }
    }
    if (lc >= left.length) {
      for (int j= 0; j < right.length; j++) {
        data[i] = right[j];
        i++;
      }
    } else {
      for (int j = 0; j < left.length; j++) {
        data[i] = left[j];
        i++;
      }
    }
  }

}
