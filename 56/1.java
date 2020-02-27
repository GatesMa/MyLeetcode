class Solution {

    public int[][] merge(int[][] intervals) {
        
        LinkedList<Interval> temp = new LinkedList<>();
        for(int i = 0;i < intervals.length;i++) {
            temp.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(temp, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start.compareTo(b.start);
            }
        });
        LinkedList<Interval> res = new LinkedList<>();
        for(int i = 0;i < temp.size();i++) {
            if(res.isEmpty() || res.getLast().end < temp.get(i).start) {
                res.add(temp.get(i));
            } else {
                res.getLast().end = Math.max(res.getLast().end, temp.get(i).end);
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0;i < res.size();i++) {
            ans[i][0] = res.get(i).start;
            ans[i][1] = res.get(i).end;
        }
        
        return ans;
    }

}
class Interval {
    public Integer start;
    public Integer end;
    public Interval(){}
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
