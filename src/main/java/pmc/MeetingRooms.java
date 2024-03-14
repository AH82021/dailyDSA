package pmc;

/*
On a given day, there are n meetings scheduled.
There is a list of the meetings given as a 2D array, meetingTimings, of size n x m,
 that contains the start and end times of the meetings. Determine the minimum number of meeting rooms needed to conduct all the meetings so that no meetings overlap in a meeting room.
Note: Meetings can end and begin at the same time in one room. For example, meetings at times [10, 15], and [15, 20] can be held in the same room.
 */

import java.util.*;

public class MeetingRooms {
    public static int getMinRooms(List<List<Integer>> meetingTimings) {
        // Sort the meeting timings by start time
        Collections.sort(meetingTimings, (a, b) -> a.get(0) - b.get(0));

        // Priority queue to store the end times of meetings
        PriorityQueue<Integer> allocator = new PriorityQueue<>(meetingTimings.size(), Integer::compare);

        // Iterate over the meeting timings
        for (List<Integer> meeting : meetingTimings) {
            // If a meeting has ended, remove it from the queue
            if (!allocator.isEmpty() && allocator.peek() <= meeting.get(0)) {
                allocator.poll();
            }
            // Add the current meeting's end time to the queue
            allocator.offer(meeting.get(1));
        }

        // The size of the allocator is the minimum number of rooms required
        return allocator.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> meetings = Arrays.asList(
                Arrays.asList(2, 8),
                Arrays.asList(3, 9),
                Arrays.asList(5, 11),
                Arrays.asList(3, 4),
                Arrays.asList(11, 15),
                Arrays.asList(8, 20)
        );
        List<List<Integer>> meetings2 = Arrays.asList(
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(5, 6),
                Arrays.asList(6,10),
                Arrays.asList(7, 9)

        );
        System.out.println(getMinRooms(meetings2));



        System.out.println("Minimum number of meeting rooms required: " + getMinRooms(meetings));
    }
}