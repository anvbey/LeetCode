//LeetCode 1461
/*
Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.



        Example 1:

        Input: s = "00110110", k = 2
        Output: true
        Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
        Example 2:

        Input: s = "0110", k = 1
        Output: true
        Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
        Example 3:

        Input: s = "0110", k = 2
        Output: false
        Explanation: The binary code "00" is of length 2 and does not exist in the array.


        Constraints:

        1 <= s.length <= 5 * 105
        s[i] is either '0' or '1'.
        1 <= k <= 20
*/
class Solution {

    public boolean hasAllCodes(String S, int K) {
        int len = S.length(), count = 1 << K;
        if (K > len) return false;
        int num = K > 1 ? Integer.parseInt(S.substring(len - K + 1), 2) << 1 : 0;
        boolean[] seen = new boolean[count];
        for (int i = len - K; i >= 0; i--) {
            num = (((S.charAt(i) - '0') << K) + num) >> 1;
            if (!seen[num]) {
                seen[num] = true;
                count--;
            }
            if (count == 0) return true;
            if (i < count) return false;
        }
        return false;
    }
}