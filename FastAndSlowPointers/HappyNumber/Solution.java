/**
 * https://leetcode.com/problems/happy-number/description/
 */
class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;
        int fast = getNextSquaredNumber(n), slow = n;
        while (fast != slow) {
            if (fast == 1) {
                return true;
            }
            slow = getNextSquaredNumber(slow);
            fast = getNextSquaredNumber(getNextSquaredNumber(fast));
        }
        return false;
    }
    private int getNextSquaredNumber(int n) {
        int value = 0;
        while(n>0) {
            int lastDigit = n%10;
            n = n/10;
            value += lastDigit*lastDigit;
        }
        return value;
    }
}
