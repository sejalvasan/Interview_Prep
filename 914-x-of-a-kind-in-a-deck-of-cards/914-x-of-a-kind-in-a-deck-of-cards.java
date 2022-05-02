class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i =0;i<deck.length;i++){
        int freq = map.getOrDefault(deck[i],0)+1;
            map.put(deck[i],freq);
        }
        int ans=0;
       for(int key:map.keySet()){
        ans=gcd(ans,map.get(key));
        }
        if(ans>=2)
            return true;
        
        return false;
    }
    
    public static int gcd(int n1 , int n2){
        while(n1%n2!=0){
            int rem = n1%n2;
            n1=n2;
            n2=rem;
        }
        return n2;
    }
}