/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

public int findInMountainArray(int target, MountainArray mountainArr) {

    int i=0;
    int j=mountainArr.length()-1;
    //finding the peak element in mountain Array
    while(i<j){
        int m= (i+j)/2;
        if(mountainArr.get(m) < mountainArr.get(m+1)) i=m+1;
        if(mountainArr.get(m) > mountainArr.get(m+1)) j=m;
    }
    
    // search element in in increasing part of array 
    int lo=0 ,hi=i;
    while(lo<=hi){
        int m= (lo+hi)/2;
        if(target > mountainArr.get(m)) lo=m+1;
        else if(target < mountainArr.get(m)) hi=m-1;
        else return m; // if element is found return its index
    }
    
    // search element in in decreasing part of array 
    lo=i;
    hi=mountainArr.length()-1;
    while(lo<=hi){
        int m= (lo+hi)/2;
        if(target < mountainArr.get(m)) lo=m+1;
        else if(target > mountainArr.get(m)) hi=m-1;
        else return m; // if element is found return its index
    }
    return -1; // if element is not found return -1 
}
}