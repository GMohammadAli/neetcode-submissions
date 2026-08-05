class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        int idx = 0;

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < n; i++) {
                result[idx++] = nums[i];
            }
        }

        return result;
    }
}