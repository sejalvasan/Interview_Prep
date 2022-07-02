class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int height = maxDiff(horizontalCuts,h);
        int width = maxDiff(verticalCuts,w);
        
       long ans =1l*height*width;
        
        return (int)(ans%1000000007);
        }
    
    public int maxDiff(int arr[], int height){
        int maxHeight = arr[0];
        
        for(int i =1;i<arr.length;i++){
            maxHeight = Math.max(arr[i]-arr[i-1],maxHeight);
        }
        
        maxHeight = Math.max(maxHeight, height-arr[arr.length-1]);
        
        return maxHeight;
    }
}