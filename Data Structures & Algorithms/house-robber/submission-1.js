class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    rob(nums) {
        const memo = [];
        for (let _num in nums) {
            memo.push(-1);
        }
        const rob = (ind) => {
            if (ind >= nums.length) return 0;

            if (memo[ind] != -1) return memo[ind];

            return (memo[ind] = Math.max(nums[ind] + rob(ind + 2), rob(ind + 1)));
        };

        return Math.max(rob(0), rob(1));
    }
}
