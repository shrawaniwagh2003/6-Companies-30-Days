# Problem: Number of Nice Subarrays

You are given an array of integers `nums` and an integer `k`. A **nice** subarray is defined as a subarray that contains exactly `k` odd numbers.

LINK :https://leetcode.com/problems/count-number-of-nice-subarrays/

## Problem Statement

Return the number of **nice** subarrays.

### Example 1:

**Input**: `nums = [1,1,2,1,1], k = 3`

**Output**: `2`

**Explanation**:
- The subarrays with exactly 3 odd numbers are:
  - `[1, 1, 2, 1]`
  - `[1, 2, 1, 1]`

### Example 2:

**Input**: `nums = [2,4,6], k = 1`

**Output**: `0`

**Explanation**:
- There are no odd numbers in the array, so no subarrays contain exactly 1 odd number.

### Example 3:

**Input**: `nums = [2,2,2,1,2,2,1,2,2,2], k = 2`

**Output**: `16`

## Approach

### Sliding Window Technique

To solve this problem, we can use the **sliding window technique**. The idea is to count the number of subarrays that contain **at most `k` odd numbers** and then subtract the number of subarrays that contain **at most `k-1` odd numbers**. This difference gives us the subarrays that contain exactly `k` odd numbers.

### Steps:
1. **Count Subarrays with at Most `k` Odd Numbers**:
   - We use two pointers, `l` and `r`, where `r` expands the window and `l` shrinks it when the number of odd numbers in the window exceeds `k`.
   
2. **Count Subarrays with at Most `k-1` Odd Numbers**:
   - Similarly, we count subarrays that contain at most `k-1` odd numbers.
   
3. **Final Result**:
   - The final result is the difference between the count of subarrays with at most `k` odd numbers and the count of subarrays with at most `k-1` odd numbers.

### Code Implementation

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    // Helper function to count subarrays with at most 'k' odd numbers
    private int atMostK(int[] nums, int k) {
        int l = 0, count = 0, oddCount = 0;
        
        for (int r = 0; r < nums.length; r++) {
            // If the number at index r is odd, increase the odd count
            if (nums[r] % 2 != 0) {
                oddCount++;
            }
            
            // Shrink the window until the odd count is less than or equal to k
            while (oddCount > k) {
                if (nums[l] % 2 != 0) {
                    oddCount--;
                }
                l++;
            }
            
            // Add the number of subarrays ending at index r and starting from any index between l and r
            count += r - l + 1;
        }
        
        return count;
    }
}
