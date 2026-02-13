import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length <= 1)
            return intervals;
        
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        
        int[] current = intervals[0];
        result.add(current);
        
        // Step 2: Merge intervals
        for (int i = 1; i < intervals.length; i++) {
            
            if (intervals[i][0] <= current[1]) {
                // Overlapping → merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap → move to next
                current = intervals[i];
                result.add(current);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
