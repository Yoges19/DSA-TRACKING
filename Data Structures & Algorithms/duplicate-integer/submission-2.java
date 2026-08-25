class Solution {
    public boolean hasDuplicate(int[] nums) {
         if (nums == null || nums.length <= 1) return false;
        Arrays.sort(nums);
        for(int j = 1;j<nums.length;j++){
            if(nums[j] == nums[j-1]) return true;
        }
        return false;
    }
}