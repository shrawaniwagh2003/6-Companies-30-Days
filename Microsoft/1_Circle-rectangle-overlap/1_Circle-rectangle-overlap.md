# Circle and Rectangle Overlap

This document explains the algorithm and implementation for determining whether a circle and an axis-aligned rectangle overlap.

---

## Problem Statement
You are given a circle represented as:
- **Radius**: `r`
- **Center**: `(xCenter, yCenter)`

And a rectangle represented as:
- **Bottom-left corner**: `(x1, y1)`
- **Top-right corner**: `(x2, y2)`

You need to check if there is any point `(x, y)` that lies both inside the circle and inside the rectangle. If such a point exists, return `true`; otherwise, return `false`.

---

## Key Conditions
### Circle Condition:
A point `(x, y)` lies inside or on the circle if:
```math
(x - xCenter)^2 + (y - yCenter)^2 \leq r^2
```

### Rectangle Condition:
A point `(x, y)` lies inside or on the rectangle if:
```math
x1 \leq x \leq x2 \quad \text{and} \quad y1 \leq y \leq y2
```

---

## Simplified Approach
### Step 1: Find the Closest Point
Find the point `(xClosest, yClosest)` on the rectangle that is closest to the circle's center `(xCenter, yCenter)`:

- **Clamp the x-coordinate**:
  ```
  xClosest = clamp(xCenter, x1, x2)
  ```
  - If `xCenter < x1`, then `xClosest = x1`
  - If `xCenter > x2`, then `xClosest = x2`
  - Otherwise, `xClosest = xCenter`

- **Clamp the y-coordinate**:
  ```
  yClosest = clamp(yCenter, y1, y2)
  ```
  - If `yCenter < y1`, then `yClosest = y1`
  - If `yCenter > y2`, then `yClosest = y2`
  - Otherwise, `yClosest = yCenter`

### Step 2: Check the Distance
Calculate the squared distance from the circle's center to the closest point:
```math
\text{distance}^2 = (xClosest - xCenter)^2 + (yClosest - yCenter)^2
```
If this distance is less than or equal to the square of the radius (`r^2`), the circle and rectangle overlap.

---

## Algorithm
1. Input the circle's radius, center `(xCenter, yCenter)`, and rectangle corners `(x1, y1)` and `(x2, y2)`.
2. Compute the closest point `(xClosest, yClosest)`:
   - `xClosest = clamp(xCenter, x1, x2)`
   - `yClosest = clamp(yCenter, y1, y2)`
3. Calculate the squared distance:
   ```
   distanceSquared = (xClosest - xCenter)^2 + (yClosest - yCenter)^2
   ```
4. Compare the squared distance with the square of the radius:
   - If `distanceSquared <= r^2`, return `true` (overlap exists).
   - Otherwise, return `false`.

---

## Complexity
### Time Complexity:
- **O(1)**: All calculations involve simple arithmetic operations.

### Space Complexity:
- **O(1)**: No additional space is used.

---

## Example Walkthrough
### Example 1:
**Input**:
```
radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
```

**Closest Point Calculation**:
- `xClosest = clamp(0, 1, 3) = 1`
- `yClosest = clamp(0, -1, 1) = 0`

**Distance Calculation**:
```
distanceSquared = (1 - 0)^2 + (0 - 0)^2 = 1
```

**Check**:
```
distanceSquared <= r^2 -> 1 <= 1 (True)
```

**Output**:
```
true
```

---

## Implementation
```java
public class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest point on the rectangle to the circle's center
        int xClosest = clamp(xCenter, x1, x2);
        int yClosest = clamp(yCenter, y1, y2);

        // Calculate the squared distance from the circle's center to the closest point
        int distanceSquared = (xClosest - xCenter) * (xClosest - xCenter) +
                              (yClosest - yCenter) * (yClosest - yCenter);

        // Check if the distance is within the circle's radius
        return distanceSquared <= radius * radius;
    }

    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }
}
```