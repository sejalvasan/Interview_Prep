class Solution {
    
     public void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
    public int maximumSwap(int num) {
    String s = String.valueOf(num);
    char[] arr = s.toCharArray();

    int[] iarr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      iarr[arr[i] - '0'] = i;
    }

    boolean flag = false;
    for (int i = 0; i < arr.length; i++)  {
      for (int j = 9; j > arr[i] - '0'; j--) {
        if (iarr[j] > i) {
          swap(arr, iarr[j], i);
          flag = true;
          break;
        }
      }
      if (flag == true) {
        break;
      }
    }

    String res = "";
    for (int i = 0; i < arr.length; i++) {
      res += arr[i];
    }
    return Integer.parseInt(res);
  }
}