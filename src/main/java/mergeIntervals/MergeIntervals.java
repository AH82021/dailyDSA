package mergeIntervals;

import java.util.*;

/*
Given a list of intervals, merge all the overlapping intervals
to produce a list that has only mutually exclusive intervals.
Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

public class MergeIntervals{

    public static List<Interval> merge(List<Interval> intervals){

        if(intervals.size() <2){
            return intervals;
        }
        Collections.sort(intervals,(a,b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;
        while (intervalItr.hasNext()){
            interval = intervalItr.next();
            if(interval.start <= end){
                end = Math.max(interval.end,end);

            } else {
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start,end));

        return mergedIntervals;

    }

    public static void main(String[] args) {

    }
}
