class Solution {
    public int countPrimes(int n) {
       boolean []arr = new boolean[n];
        
        //false - prime
        //true - not prime
        int num=0;
        for(int i =2;i*i<=n;i++){
            if(arr[i]==false){
                for(int j=2*i;j<n;j+=i){
                    arr[j]=true;
                }
            }
        }
        
        for(int i=2;i<n;i++){
            if(arr[i]==false)
                num++;
        }
        
        return num;
    }
}