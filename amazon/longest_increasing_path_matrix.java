class LargestIncreasingPathMatrix{

    static int getLargestPath(int[][] mat){
        if(mat == null || mat.length == 0) return 0;
        if(mat.length==1 && mat[0].length==1) return mat[0][0];
        int largestPath = 0;
        int[][] dp = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j < mat[i].length;j++){
                int path = 1 + walk(mat,dp, i, j);
                largestPath = Math.max(path, largestPath);
            }
        }
        return largestPath;
    }

    static int walk(int[][] mat, int[][] dp, int i, int j){
        if(dp[i][j] > 0) return dp[i][j];
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int maxLength = 0;
        for(int d=0; d<dir.length; d++){
            int r = i+dir[d][0];
            int c = j+dir[d][1];

            if(!isSafe(r, c, mat) || mat[r][c] <= mat[i][j]) continue;
            int pathLen = 1 + walk(mat, dp, r, c);
            maxLength = Math.max(maxLength, pathLen);
        }
        dp[i][j] = maxLength;
        return maxLength;
    }

    static boolean isSafe(int r, int c, int[][] mat) {
        if(r >= mat.length || r < 0 || c >= mat[0].length || c <0) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][]arr = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(getLargestPath(arr));
    }
}