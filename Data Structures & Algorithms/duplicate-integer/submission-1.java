class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();

        for(int num : nums) {
            visited.add(num);
        }
        
        return visited.size() != nums.length;
    }
}