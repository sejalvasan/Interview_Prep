class Solution {
    public int nextGreaterElement(int n) {
        char arr[] = String.valueOf(n).toCharArray();
        int l = arr.length;
        int i = l-2,j=l-1;
        while(i>=0 && arr[i]>=arr[i+1])
            i--;
        if(i<0)
            return -1;
        while(j>=0 && arr[j]<=arr[i])
            j--;
      //  if(i>=0)
            swap(arr,i,j);
        
        reverse(arr, i+1, l-1);
        
       long val = Long.valueOf(String.valueOf(arr));
        return val <= Integer.MAX_VALUE ? (int) val : -1; 
    }
    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    
    public static void reverse(char[]array, int i , int j){
        while(i<j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
            i++;
            j--;
        }
    }
}