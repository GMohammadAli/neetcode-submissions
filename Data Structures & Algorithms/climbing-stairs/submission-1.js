class Solution {
    /**
     * @param {number} n
     * @return {number}
     */
    climbStairs(n) {
        const memo = [];
        for(let i = 0; i <= n; i++) {
            memo.push(-1);
        }

        const climbStairs = (n) => {
            if(n == 0) return 1;
            if(n < 0) return 0;

            if(memo[n] != -1) return memo[n];

            return memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }

        // return climbStairs(n);

        const dp = [];
        for(let i = 0; i <= n; i++) {
            dp.push(0);
        }

        dp[0] = 1;
        dp[1] = 1;

        for(let i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
