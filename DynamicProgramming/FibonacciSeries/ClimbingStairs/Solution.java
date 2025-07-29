/**
 * https://leetcode.com/problems/climbing-stairs/
 * This is classic fibonacci series. We need to compute
 * in how many ways we can reach to (n-1)th and (n-2)th 
 * steps. Then summation of those are the final result.
 */
class Solution {
public:
    int climbStairs(int n) {
        if(n==1 || n==2) {
            return n;
        }
        int minusTwoValue = 1, minusOneValue = 2, current = 0;
        for(int i=3; i<=n; i++) {
            current = minusTwoValue + minusOneValue;
            minusTwoValue = minusOneValue;
            minusOneValue = current;
        }
        return current;
    }
};
