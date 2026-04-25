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
        List<Integer> roomsWithEndTime = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        roomsWithEndTime.add(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            boolean added = false;
            for(int j = 0; j < roomsWithEndTime.size(); j++) {
                int roomEndTime = roomsWithEndTime.get(j);
                if(roomEndTime <= interval.start) {
                    added = true;
                    roomEndTime = Math.max(roomEndTime, interval.end);
                    roomsWithEndTime.set(j, roomEndTime);
                    break;
                }
            }
            if(!added) roomsWithEndTime.add(interval.end);
        }

        return roomsWithEndTime.size();
    }
}
