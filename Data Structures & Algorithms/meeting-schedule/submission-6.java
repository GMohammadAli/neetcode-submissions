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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int prevEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (prevEnd > interval.start) {
                return false;
            } else {
                prevEnd = Math.max(prevEnd, interval.end);
            }
        }

        return true;
    }
}
