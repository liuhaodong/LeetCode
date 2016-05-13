package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haodongl on 12/10/15
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */




public class InsertInterval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public String toString(){
            return start + " " + end;
        }
    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<Interval>();

        if(intervals == null ){
            return result;
        }else if(intervals.size() ==0){
            result.add(newInterval);
            return result;
        }

        Interval tmp = new Interval(newInterval.start, newInterval.end);

        boolean isInserted = false;

        for(Interval interval : intervals){
            if(interval.end < tmp.start){
                result.add(interval);
            }else if(!isInserted &&  !( tmp.start > interval.end || tmp.end < interval.start) ){

                tmp.start = tmp.start < interval.start?tmp.start:interval.start;
                tmp.end = tmp.end >interval.end?tmp.end:interval.end;

            }else if(!isInserted && interval.start > tmp.end){
                result.add(tmp);
                result.add(interval);
                isInserted = true;
            }else {
                result.add(interval);
            }
        }

        if(!isInserted)
            result.add(tmp);

        return result;
    }

    public static void main(String[] args){
        List<Interval> intervalList = new ArrayList<Interval>();
        intervalList.add(new Interval(1,5));
        intervalList.add(new Interval(6,7));
        intervalList.add(new Interval(8,9));
        System.out.println(new InsertInterval().insert(intervalList, new Interval(-1,1)));
    }
}
