public class Merge{
  public static void mergesort(int[] data) {
    int[] left = new int[data.length/2];
    int[] right = new int[data.length-data.length/2];
    for (int i = 0; i <data.length; i++) {
      if (i <= data.length/2) {
        left[i] = data[i];
      } else {
        right[i] = data[i];
      }
    }
    
  }
}
