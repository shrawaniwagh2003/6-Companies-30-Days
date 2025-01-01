# Random Point in Rectangle

## Problem Description

You are given an array of non-overlapping axis-aligned rectangles `rects` where `rects[i] = [ai, bi, xi, yi]` indicates that `(ai, bi)` is the bottom-left corner point of the ith rectangle and `(xi, yi)` is the top-right corner point of the ith rectangle. Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included in the space covered by the rectangle.

Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.

Note that an integer point is a point that has integer coordinates.

Implement the `Solution` class:

```java
class Solution {
    // List of rectangles
    private int[][] rects;
    private int[] prefixSum;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSum = new int[rects.length];
        int totalPoints = 0;

        // Precompute the number of points in each rectangle and store prefix sums
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int ai = rect[0], bi = rect[1], xi = rect[2], yi = rect[3];
            int numPoints = (xi - ai + 1) * (yi - bi + 1);
            totalPoints += numPoints;
            prefixSum[i] = totalPoints;
        }
    }

    public int[] pick() {
        // Pick a random point in the total range
        int totalPoints = prefixSum[prefixSum.length - 1];
        int randPoint = (int) (Math.random() * totalPoints) + 1;

        // Use binary search to find the rectangle that contains the random point
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] < randPoint) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Find the rectangle where the point falls
        int[] rect = rects[left];
        int ai = rect[0], bi = rect[1], xi = rect[2], yi = rect[3];
        int rectStart = (left > 0) ? prefixSum[left - 1] : 0;

        // The point within the selected rectangle
        int pointIndex = randPoint - rectStart - 1;
        int dx = pointIndex % (xi - ai + 1);
        int dy = pointIndex / (xi - ai + 1);

        return new int[] { ai + dx, bi + dy };
    }
}
```

# Explanation

## Problem Breakdown
You are given a set of non-overlapping rectangles. The objective is to pick a random integer point that lies inside any one of the rectangles, including the boundary. Each rectangle is represented by its bottom-left corner `(ai, bi)` and its top-right corner `(xi, yi)`.

- A point on the boundary of a rectangle is considered to be inside that rectangle.
- The problem requires you to implement a method to pick a random integer point that is uniformly distributed within the covered space of all the rectangles.

## Approach

### Initialization:
- For each rectangle, calculate how many integer points it contains. This is simply the area of the rectangle.
- Store these areas cumulatively in a prefix sum array, which helps in determining the rectangle a random point falls into.

### Picking a Rectangle:
- The total number of points across all rectangles is given by the last element of the prefix sum array.
- A random integer is generated in the range [1, total_points], and a binary search is used to find which rectangle contains this random point.

### Random Point Inside the Rectangle:
- After identifying the rectangle, we calculate the exact position of the random point inside that rectangle based on its index.

## Code Walkthrough

### Solution Class:
The `Solution` class is initialized with an array of rectangles. It computes the number of integer points in each rectangle and stores the cumulative sum of these points in the `prefixSum` array.

### Pick Method:
The `pick` method generates a random integer point within the space covered by all rectangles:

1. It first picks a random point in the total range (sum of points from all rectangles).
2. Using binary search, it determines which rectangle contains the random point.
3. Then, it picks a random point inside the identified rectangle.

## Time Complexity:
- **Initialization**: O(n), where n is the number of rectangles. This is because we compute the number of points for each rectangle and fill up the prefix sum array.
- **Pick**: O(log n), because binary search is used to find the rectangle that contains the random point.

## Space Complexity:
- O(n), where n is the number of rectangles. This is because we store the prefix sum array of size n.

## Example Usage:

### Input:
```java
Solution solution = new Solution(new int[][] { {-2, -2, 1, 1}, {2, 2, 4, 6} });
solution.pick(); // Possible output: [1, -2]
solution.pick(); // Possible output: [1, -1]
solution.pick(); // Possible output: [-1, -2]
solution.pick(); // Possible output: [-2, -2]
solution.pick(); // Possible output: [0, 0]
```

### Conclusion:
The solution uses the prefix sum technique combined with binary search to efficiently select random points inside non-overlapping rectangles. This approach ensures that the points are chosen uniformly at random while maintaining efficiency in both time and space.