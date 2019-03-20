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
  //Sort testing code
    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;

    private static String name(int i){
      if(i==INCREASE)return "Increassing";
      if(i==DECREASE)return "Decreassing";
      if(i==STANDARD)return "Normal Random";
      if(i==SMALL_RANGE)return "Random with Few Values";
      return "Error categorizing array";

    }

    private static int create(int min, int max){
      return min + (int)(Math.random()*(max-min));
    }

    private static int[]makeArray(int size,int type){
      int[]ans =new int[size];
      if(type == STANDARD){
        for(int i = 0; i < size; i++){
          ans[i]= create(-1000000,1000000);
        }
      }
      else if(type == INCREASE){
        int current = -5 * size;
        for(int i = 0; i < size; i++){
          ans[i]= create(current,current + 10);
          current += 10;
        }
      }
      else if(type == DECREASE){
        int current = 5 * size;
        for(int i = 0; i < size; i++){
          ans[i]= create(current,current + 10);
          current -= 10;
        }
      }
      else if(type == SMALL_RANGE){
        for(int i = 0; i < size; i++){
          ans[i]= create(-5,5);
        }
      }
      else{
        ans = new int[0];//empty is default
      }
      return ans;
    }

    public static void main(String[]args){
      if(args.length < 2)return;

      int size =  Integer.parseInt(args[0]);
      int type =   Integer.parseInt(args[1]);

      int [] start = makeArray(size,type);
      int [] result = Arrays.copyOf(start,start.length);
      Arrays.sort(result);

      long startTime = System.currentTimeMillis();
      /*
       * Test your sort here //yoursort(start);
       * Add code to switch which sort is tested by changing one of the args!
       */
      mergesort(start);
      long elapsedTime = System.currentTimeMillis() - startTime;
      if(Arrays.equals(start,result)){
        System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
      }else{
        System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
      }
    }

}
