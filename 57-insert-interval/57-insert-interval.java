
class Solution {

public int[][] insert(int[][] intervals, int[] newInterval) {
//     List<int[]> list = new ArrayList<>();
//     List<int[]> res = new ArrayList<>();
    
//     for(int[] arr : intervals)
//         list.add(arr);
//     list.add(newInterval);
    
//     // sort
//     Collections.sort(list, (a, b) -> a[0] - b[0]);
    
//     int start = list.get(0)[0], end = list.get(0)[1];
    
//     for(int[] arr : list) {
//         if(arr[0] <= end)
//             end = Math.max(end, arr[1]);
//         else {
//             res.add(new int[]{start, end});
//             start = arr[0];
//             end = arr[1];
//         }
//     }
    
//     res.add(new int[]{start, end});
    
//     return res.toArray(new int[0][]);
// }
// }
    
    ArrayList<int[]>res = new ArrayList<>();
    int idx =0;
    
    while(idx<intervals.length){
        if(intervals[idx][0]<newInterval[0]){
            res.add(intervals[idx]);
            idx++;
        }else{
          break;
            }
        }
    
    //no interval is smaller than new interval then list will be empty so far
    if(res.size()==0 || newInterval[0]>res.get(res.size()-1)[1]){
        res.add(newInterval);
    }else{
    int lastInterval[]= res.get(res.size()-1);
    lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
}
    
    //bache hue intervals will either overlap or not overlap
    
    while(idx<intervals.length){
        int lastInterval[] = res.get(res.size()-1);
        if(lastInterval[1]>=intervals[idx][0]){
            //merge
        lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]); 
        }else{
            res.add(intervals[idx]);
        }
        idx++;
    }
        return res.toArray(new int[0][]);
}
}
    