class Solution {
    public int nthUglyNumber(int N) {
        
        int ugly[] = new int[N+1];
        int i2 = 1, i3 = 1, i5 = 1;
  
        ugly[1] = 1;
  
        for (int i = 2; i <= N; i++) 
        {
            int f1 =ugly[i2]*2;
            int f2 =ugly[i3]*3;
            int f3 =ugly[i5]*5;
            
            ugly[i] = Math.min(f1,Math.min(f2,f3));
            
            if (ugly[i] == f1) 
            {
                i2 = i2 + 1;
            }
            if (ugly[i] == f2)
            {
                i3 = i3 + 1;
            }
            if (ugly[i] == f3)
            {
                i5 = i5 + 1;
            }
        } 
        return ugly[N];
    }
}