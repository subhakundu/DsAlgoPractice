/**
 * https://leetcode.com/problems/merge-intervals/description/
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // comparator methods
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval: intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }
        return merged.toArray(int[][]::new);
    }
}
