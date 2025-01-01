# Russian Doll Envelopes Problem

## Problem Description
You are given a 2D array of integers `envelopes` where `envelopes[i] = [wi, hi]` represents the width and height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

### Example 1:

**Input:**
```
envelopes = [[5,4],[6,4],[6,7],[2,3]]
```
**Output:**
```
3
```
**Explanation:**
The maximum number of envelopes you can Russian doll is 3 (`[2,3] => [5,4] => [6,7]`).

### Example 2:

**Input:**
```
envelopes = [[1,1],[1,1],[1,1]]
```
**Output:**
```
1
```

### Constraints:
- \( 1 \leq \text{envelopes.length} \leq 10^5 \)
- \( 	ext{envelopes}[i].length == 2 \)
- \( 1 \leq w_i, h_i \leq 10^5 \)

---

## Java Solution
```java
import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width in ascending order.
        // If widths are the same, sort by height in descending order.
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Extract heights from sorted envelopes.
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // Find the length of the Longest Increasing Subsequence (LIS) of heights.
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, length, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == length) {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] envelopes1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(solution.maxEnvelopes(envelopes1)); // Output: 3

        int[][] envelopes2 = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println(solution.maxEnvelopes(envelopes2)); // Output: 1
    }
}
```

---

### Explanation of Code
1. **Sorting:**
   - The envelopes are sorted by width in ascending order.
   - If two envelopes have the same width, they are sorted by height in descending order. This ensures that envelopes with the same width cannot fit into each other.

2. **Extracting Heights:**
   - After sorting, only the heights are considered for finding the Longest Increasing Subsequence (LIS).

3. **Finding LIS:**
   - The LIS is computed using a binary search approach for efficiency.
   - This gives the maximum number of envelopes that can be nested.

### Complexity
- **Sorting:** \( O(n \log n) \)
- **Finding LIS:** \( O(n \log n) \)
- **Overall:** \( O(n \log n) \)

This approach is efficient and handles the constraints effectively.

