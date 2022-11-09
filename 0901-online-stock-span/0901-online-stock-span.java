class StockSpanner {
    
    class Spanner{
        int ele;
        int idx;
        Spanner(int ele, int idx){
            this.ele = ele;
            this.idx = idx;
        }
    }
    
 Stack<Spanner> st ;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    int i = -1;
    public int next(int price) {
        i++;
        int val = 0;
        if(st.isEmpty()){
            st.add(new Spanner(price,i));
            val =-1;
        }
        
      else  if(!st.isEmpty() && st.peek().ele>price){
            val = st.peek().idx;
            st.push(new Spanner(price,i));
        }
        
      else if(!st.isEmpty() && st.peek().ele<=price){
            while(!st.isEmpty() && st.peek().ele<=price){
                st.pop();
            }
            if(st.isEmpty()){
           val = -1;
            }else
            val = st.peek().idx;
            st.push(new Spanner(price,i));
        }
        return i-val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */