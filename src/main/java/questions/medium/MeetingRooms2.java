package questions.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */
public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length <= 1) return intervals.length;

        int result = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[1] - b[1];
        });

        Arrays.sort(intervals, (a, b)->{
            return a[0] != b[0] ? a[0] - b[0]: a[1] - b[1];
        });

        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= pq.peek()[1]){
                pq.poll();
            }
            pq.offer(intervals[i]);
            result = Math.max(result, pq.size());
        }
        return result;
    }

}
