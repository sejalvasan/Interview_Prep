class Data{
    String val;
    int timestamp;
    
    public Data(String val, int timestamp){
        this.val = val;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    HashMap<String, List<Data>> map;
    
    public TimeMap() {
       map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        
        map.get(key).add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        
        return binarySearch(list, timestamp);
    }
    
    public String binarySearch(List<Data> list, int timestamp){
        int l = 0, r = list.size()-1;
        
        while(l<r){
            int mid = (l+r+1)/2;
            if(list.get(mid).timestamp<=timestamp) l = mid;
            else r = mid-1;
        }
        
        Data closeData = list.get(l);
        
        return closeData.timestamp > timestamp ? "" : closeData.val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */