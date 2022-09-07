class Solution {
  public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int []> maxHeap = new PriorityQueue<>((a,b) -> distance(b) - distance(a));
    
    for(int [] point : points){ // add elements to the heap
        maxHeap.add(point);
        if(maxHeap.size() > k){ // if size greater than k, remove the head (head is the farthest distance)
            maxHeap.poll();
        }
    }
    
    int [][] result = new int [k][2]; //create a new result array that is of size k
    
    while(k-- > 0){
        result[k] = maxHeap.poll(); //keep removing elements until k is 0. 
    }
    
    return result;

}

public int distance(int[]test){ // finds the maximum point
    int x = test[0];
    int y = test[1];
    
    return x*x + y*y;
}
}