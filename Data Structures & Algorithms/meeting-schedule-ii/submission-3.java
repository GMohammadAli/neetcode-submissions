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
        if(intervals.size() == 0) return 0;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> roomEndHeap = new PriorityQueue<>();

        for(Interval interval : intervals) {
            if(roomEndHeap.isEmpty() || roomEndHeap.peek() > interval.start) {
                roomEndHeap.offer(interval.end);
            } else {
                roomEndHeap.offer(Math.max(interval.end, roomEndHeap.poll()));
            }
        }

        return roomEndHeap.size();
    }
}
