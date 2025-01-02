# Bulls and Cows Game Explanation

In this problem, you are playing the **Bulls and Cows** game with your friend.

LINK : https://leetcode.com/problems/bulls-and-cows/

## Game Overview:

1. You choose a secret number and ask your friend to guess what the number is.
2. When your friend makes a guess, you give a hint containing:
   - **Bulls**: The number of digits in the guess that are in the correct position.
   - **Cows**: The number of digits in the guess that are in your secret number but in the wrong position. These digits could potentially be rearranged to become bulls.

## Problem Definition:

Given the secret number and your friend's guess, return a hint in the format `"xAyB"`, where:
- `x` is the number of bulls (correct digits in the correct positions).
- `y` is the number of cows (correct digits in the wrong positions).

Note:
- Both the secret number and the guess can contain duplicate digits.
- The hint format is **"xAyB"**.

## Examples

### Example 1:
**Input**:
- secret = "1807"
- guess = "7810"

**Output**:
- "1A3B"

**Explanation**:
- Bulls: Only one digit `7` is in the correct position.
- Cows: The digits `1`, `8`, and `0` are present in the secret number but are in the wrong positions.
  - "1807"  
    `|`
  - "7810"

### Example 2:
**Input**:
- secret = "1123"
- guess = "0111"

**Output**:
- "1A1B"

**Explanation**:
- Bulls: One digit `1` is in the correct position.
- Cows: One `1` is in the guess but in the wrong position. The other `1` is counted as a cow because the non-bull digits can be rearranged such that one of the `1`s becomes a bull.
  - "1123"  
    `|`
  - "0111"

## Approach

To solve this, we will:
1. First, identify the bulls by checking the digits in the correct positions.
2. Then, use a frequency count of the remaining digits in the secret and the guess to determine the cows.
3. Return the final count of bulls and cows in the format "xAyB".