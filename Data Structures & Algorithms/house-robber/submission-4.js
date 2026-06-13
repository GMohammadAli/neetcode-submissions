class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    rob(nums) {
        const n = nums.length;
        if(n === 1) return nums[0];

        let dp1 = nums[0];
        let dp2 = Math.max(nums[0], nums[1]);
        for (let i = 2; i < n; i++) {
            const temp = Math.max(nums[i] + dp1, dp2);
            dp1 = dp2;
            dp2 = temp;
        }

        return Math.max(dp1, dp2);
    }
}
