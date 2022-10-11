class Solution {
    public boolean increasingTriplet(int[] a) {
       int size = a.length;
       int[]lis = new int[size];
       lis[0] = a[0];
       int lastIndex = 0;
       
       for(int i = 1;i<size;i++){
           
           int index = binarySearch(lis, 0, lastIndex, a[i]);
           lis[index] = a[i];
           lastIndex = Math.max(index, lastIndex);
       }
        if(lastIndex+1>=3)
        return true;
        
        return false;
    }
    
       public int binarySearch(int arr[], int l, int h, int value)
    {
      if(value>arr[h]) return h+1;
      
      while(l<h){
          int mid = l+(h-l)/2;
          
          if(arr[mid]==value)
          return mid;
          
          else if(arr[mid]<value)
          l = mid+1;
          
          else
          h = mid;
      }
      
      return h;
    }
}