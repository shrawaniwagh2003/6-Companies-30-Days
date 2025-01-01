# Image Smoother Problem

## Problem Description

We are given a **grayscale image** represented by a 2D integer matrix `img` of size `m x n`, where each element of the matrix represents the pixel intensity of that position in the image.

Our task is to **apply a 3x3 smoothing filter** to each pixel in the image, where each pixel's value is replaced by the average of its value and the values of its 8 surrounding neighbors. The average is calculated by rounding down the result.

**Key Details:**
1. The filter is **3x3**, meaning we consider a pixel and its 8 neighbors (up, down, left, right, and the four diagonals).
2. **Edge Handling**: If a pixel lies on the border or corner of the image, not all 8 neighbors are available. In such cases, we only consider the pixels that exist in the valid range.
3. For each pixel, after calculating the average of the pixel and its neighbors, we **round down** the result (i.e., floor the average).

### Constraints:
1. `m` and `n` (the dimensions of the matrix) are between 1 and 200.
2. The pixel intensity in the image lies between 0 and 255.

## Algorithm:

1. **Initialize a result matrix** of the same size as `img` to store the smoothed image.
2. **Iterate through each cell** in the image:
   - For each cell at position `(i, j)`, initialize the sum of the cell's value.
   - Count the number of valid neighboring cells (including the cell itself).
3. For each valid neighbor, add its value to the sum.
4. Calculate the **average** by dividing the total sum by the count of valid cells, and **round down** the result (using integer division).
5. Store the floored average value in the result matrix.
6. After processing all cells, **return the result matrix**.

## Example Walkthrough:

### Example 1:

**Input**:
```plaintext
img = [[1, 1, 1],
       [1, 0, 1],
       [1, 1, 1]]
```
