import java.util.Arrays;

class CoinChange {

    static int getMinCoins(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int c: coins){
                if(i==c) dp[i] = 1;
                else{
                    if(i>c){
                        if(dp[i-c]==Integer.MAX_VALUE) continue;
                        dp[i] = Math.min(dp[i-c]+1, dp[i]);
                    }
                }

            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(getMinCoins(coins, amount));
    }
}