import java.util.HashSet;
import java.util.Set;

// Input: [100,4,200,1,3,2]
// Output: 4 (Length of longest sequence)
class LongestConsecutiveSequence {

    static int maxlen(int[] arr) {
        Set<Integer> numset = new HashSet<Integer>();
        for (int n : arr) {
            numset.add(n);
        }
        int longestStreak = 0;
        for (int n : arr) {
            if (!numset.contains(n - 1)) {
                int current = n;
                int currentStreak = 1;

                while(numset.contains(current+1)){
                    current+=1;
                    currentStreak+=1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(maxlen(new int[]{100,4,200,1,3,2}));
    }
}