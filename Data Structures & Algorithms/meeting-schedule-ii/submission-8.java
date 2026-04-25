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
			
			List<Integer> endTimeRooms = new ArrayList<>();
			Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
			
			for(Interval interval : intervals) {
				boolean roomFound = false;
				for(int i = 0; i < endTimeRooms.size(); i++) {
					int endTime = endTimeRooms.get(i);
					if(endTime <= interval.start) {
						roomFound = true;
						endTimeRooms.set(i, Math.max(interval.end, endTime));
						break;
					}
				}
				if(!roomFound) endTimeRooms.add(interval.end);
			}
			
			return endTimeRooms.size();
    }
}