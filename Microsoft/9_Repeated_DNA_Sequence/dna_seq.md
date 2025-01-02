# Problem: Repeated DNA Sequences

## Problem Statement
LINK : https://leetcode.com/problems/repeated-dna-sequences/description/

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'. For example, "ACGAATTCCG" is a DNA sequence.

When studying DNA, it is useful to identify repeated sequences within the DNA. Given a string `s` that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

### Example 1:

**Input**: `s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"`

**Output**: `["AAAAACCCCC","CCCCCAAAAA"]`

### Example 2:

**Input**: `s = "AAAAAAAAAAAAA"`

**Output**: `["AAAAAAAAAA"]`

## Constraints:
- `1 <= s.length <= 10^5`
- `s[i]` is either 'A', 'C', 'G', or 'T'.

## Approach

### Algorithm:

1. **Using a Set to Track Repeated Sequences**:
   - We need to identify all 10-letter-long substrings in the given string `s` that appear more than once.
   - We can slide a window of size 10 over the string and use a HashSet (or a HashMap) to store the substrings.
   - If a substring is found that has already been encountered, it means it's a repeated sequence, and we add it to the result.

2. **Sliding Window**:
   - Traverse through the string `s` using a sliding window of size 10.
   - For each window, extract the substring and check if it has been seen before. If yes, add it to the result.
   - Use a set to track the sequences already encountered.

### Code Implementation:

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        // Traverse the string with a window size of 10
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        
        // Convert the repeated set to a list and return
        return new ArrayList<>(repeated);
    }
}
