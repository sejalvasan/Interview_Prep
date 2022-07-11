class MyCalendarTwo {

    TreeMap<Integer, Integer> tmap ;
    public MyCalendarTwo() {
        tmap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        //insert new booking
        tmap.put(start,tmap.getOrDefault(start,0)+1);
        tmap.put(end,tmap.getOrDefault(end,0)-1);
        
        int activeBookings =0;
        
        for(int time: tmap.values()){
            activeBookings +=time;
            
            if(activeBookings>2){
                //undo it
                 tmap.put(start,tmap.getOrDefault(start,0)-1);
                 tmap.put(end,tmap.getOrDefault(end,0)+1);
                return false;
            }
        }
        return true;
        
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */