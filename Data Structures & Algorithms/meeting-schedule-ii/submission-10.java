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

        PriorityQueue<Integer> endTimeRooms = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (Interval interval : intervals) {
            if (endTimeRooms.isEmpty() || endTimeRooms.peek() <= interval.start) {
                endTimeRooms.poll();
            }
            endTimeRooms.offer(interval.end);
        }

        return endTimeRooms.size();
    }
}