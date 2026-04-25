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
        int result = 0;

        int n = intervals.size();
        int[] startInts = new int[n];
        int[] endInts = new int[n];

        int i = 0;
        for(Interval interval : intervals) {
            startInts[i] = interval.start;
            endInts[i++] = interval.end;
        }

        Arrays.sort(startInts);
        Arrays.sort(endInts);

        i = 0;
        int j = 0;
        int count = 0;
        while(i < n && j < n) {
            if(startInts[i] < endInts[j]) {
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
