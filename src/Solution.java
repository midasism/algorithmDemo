class Solution {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        //boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if (!visited[i][j]) {
                if (isPermission(i, j, k)) {
                    res++;
                }
                //visited[i][j] = true;
                //}
            }
        }
        return res;
    }

    private boolean isPermission(int x, int y, int k) {
        return calBitSum(x) + calBitSum(y) == k ? false : true;
    }

    private int calBitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.movingCount(1, 2, 1);
//        System.out.println(i);

//        System.out.println(solution.calBitSum());
    }
}