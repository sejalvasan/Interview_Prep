class Solution {
    public int peakIndexInMountainArray(int[] mountainArr) {
 
    int i=0;
    int j=mountainArr.length-1;
    //finding the peak element in mountain Array
    while(i<j){
        int m= (i+j)/2;
        if(mountainArr[m] < mountainArr[m+1]) i=m+1;
        if(mountainArr[m] > mountainArr[m+1]) j=m;
    }
     return i;
    }
}
    