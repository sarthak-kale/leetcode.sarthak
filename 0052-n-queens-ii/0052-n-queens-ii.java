class Solution {
    public int totalNQueens(int n) {
        return solve(0, n, 0, 0, 0);
    }

    private int solve(int row, int n, int cols, int diag1, int diag2) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            count += solve(
                row + 1,
                n,
                cols | bit,
                (diag1 | bit) << 1,
                (diag2 | bit) >> 1
            );
        }

        return count;
    }
}