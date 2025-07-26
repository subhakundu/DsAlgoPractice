/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<Integer>(
            (num1, num2) -> countMap.get(num1) - countMap.get(num2));

        for (int num: countMap.keySet()) {
            heap.offer(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        int [] result = new int[k];
        for (int i=k-1; i>=0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }
}
