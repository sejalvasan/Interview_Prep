class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.isEmpty()|| max.peek()>=num)
            max.add(num);
        else
            min.add(num);
        balance(max, min);
    }
    
    public double findMedian() {
     if(max.size()==min.size())
         return (max.peek()+min.peek())/2.0;
     else
         return max.peek();
    }
    
    public void balance(PriorityQueue<Integer> max, PriorityQueue<Integer> min){
        if(max.size()>min.size()+1){
            min.add(max.remove());
        }else if(min.size()>max.size())
            max.add(min.remove());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */