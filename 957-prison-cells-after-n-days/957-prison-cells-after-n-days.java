class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
      HashSet<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i<n; i++) {
            int[] nextDay = findNext(cells);
            String key = Arrays.toString(nextDay);
            if (!set.contains(key)) {
                set.add(key);
                count++;
            } else {
                //values are getting repeated so we can break
                break;
            }
            cells = nextDay;
        }
        n %= count;
        for (int i = 0; i<n; i++) {
            cells = findNext(cells);
        }
        return cells;
    }
    
    //function to find the next cell 
    public int[] findNext(int[] cells) {
        int[] temp = new int[cells.length];
        for (int i = 1; i<cells.length-1; i++) {
            temp[i] = cells[i-1]==cells[i+1]?1:0;
        }
        return temp;
    }
}