/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0)
            return 0;

        int n = intervals.size();
        
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        int i = 0;
        
        for(Interval interval : intervals) {
	        startTimes[i] = interval.start;
	        endTimes[i++] = interval.end;
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        i = 0;
        int j = 0;
        int count = 0;
        int result = 0;
        
        while(i < n && j < n) {
	        if(startTimes[i] < endTimes[j]) {
		        i++;
		        count++;
	        } else {
		        j++;
		        count--;
	        }
	        result = Math.max(count, result);
        }
        
        return result;
    }
}