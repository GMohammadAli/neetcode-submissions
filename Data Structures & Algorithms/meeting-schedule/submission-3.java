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
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval1 = intervals.get(i);
            for (int j = 0; j < intervals.size(); j++) {
                if (i == j)
                    continue;
                if (interval1.start <= intervals.get(j).start
                    && interval1.end > intervals.get(j).start) {
                    return false;
                }
            }
        }
        return true;
    }
}
