# The Josephus Problem (Friends in a Circle Game)

## Problem Statement
There are `n` friends playing a game. They sit in a circle numbered from 1 to `n` in a clockwise direction. The rules of the game are as follows:

1. Start at the 1st friend.
2. Count the next `k` friends in the clockwise direction, including the starting friend. The counting wraps around the circle, so some friends may be counted more than once.
3. The last friend counted is eliminated and leaves the circle.
4. If more than one friend remains, the process restarts from the friend immediately clockwise of the eliminated friend.
5. When only one friend remains, they are declared the winner.

### Example 1:
#### Input:
```
n = 5, k = 2
```
#### Output:
```
3
```
#### Explanation:
- Step 1: Start at friend 1.
- Step 2: Count 2 friends clockwise (friends 1 and 2).
- Step 3: Friend 2 is eliminated. Next start is friend 3.
- Step 4: Count 2 friends clockwise (friends 3 and 4).
- Step 5: Friend 4 is eliminated. Next start is friend 5.
- Step 6: Count 2 friends clockwise (friends 5 and 1).
- Step 7: Friend 1 is eliminated. Next start is friend 3.
- Step 8: Count 2 friends clockwise (friends 3 and 5).
- Step 9: Friend 5 is eliminated. Only friend 3 remains, so they are the winner.

### Example 2:
#### Input:
```
n = 6, k = 5
```
#### Output:
```
1
```
#### Explanation:
The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.

---

## Algorithm
This problem is a variation of the Josephus Problem, which can be solved using a recursive approach or an iterative simulation. Below is the explanation and algorithm:

### Recursive Solution:
The Josephus Problem can be expressed recursively as:

\[
J(n, k) =
\begin{cases}
1 & \text{if } n = 1, \\
((J(n-1, k) + k - 1) \mod n) + 1 & \text{if } n > 1.
\end{cases}
\]

- **Base Case**: If there is only one friend (`n = 1`), they are the winner.
- **Recursive Case**: For `n > 1`, the position of the winner for `n` friends is calculated using the winner's position for `n-1` friends, adjusted by the step size `k`.

### Iterative Solution:
The iterative solution simulates the game using a circular list.

1. Create a list of friends numbered from 1 to `n`.
2. Initialize the current position to 0.
3. While more than one friend remains:
   - Calculate the next position using `(current position + k - 1) % remaining friends`.
   - Remove the friend at the calculated position.
   - Update the current position to the next friend in the circle.
4. Return the last remaining friend as the winner.

---

## Implementation in Java
```java
class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        int currentPosition = 0;
        while (friends.size() > 1) {
            currentPosition = (currentPosition + k - 1) % friends.size();
            friends.remove(currentPosition);
        }
        return friends.get(0);
    }
}
```

---

## Complexity Analysis
- **Time Complexity**: \(O(n^2)\) in the worst case due to repeated list removals. Using a linked list or optimizing the process can reduce the complexity.
- **Space Complexity**: \(O(n)\) for the list of friends.

---

## Key Takeaways
- The Josephus Problem demonstrates a combination of modular arithmetic and circular data structures.
- Recursive and iterative solutions are both viable but have different performance characteristics.
- Understanding the problem's pattern can help derive the direct formula for optimal solutions.

