import java.util.*;
class The_Josephus_Problem{
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