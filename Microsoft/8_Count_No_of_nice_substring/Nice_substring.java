// package Microsoft.8_Count_No_of_nice_substring;

public class Nice_substring {
    
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1); // At most k - At most (k-1)
    }

    private int helper(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length, count = 0, sum = 0;
        boolean hasOdd = false;

        // Convert even numbers to 0 and odd numbers to 1
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0; // Even numbers become 0
            } else {
                nums[i] = 1; // Odd numbers become 1
                hasOdd = true;
            }
        }

        if (!hasOdd) return 0; // No odd numbers, no valid subarrays

        // Sliding window logic
        while (r < n) {
            sum += nums[r]; // Add the current number to the sum

            // Shrink the window if the number of odd numbers exceeds k
            while (sum > k) {
                sum -= nums[l];
                l++;
            }

            // Count subarrays with at most k odd numbers
            if (sum <= k) {
                count += r - l + 1;
            }

            r++; // Expand the window
        }

        return count;
    }
}

