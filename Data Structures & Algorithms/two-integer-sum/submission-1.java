class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            int rem = target - nums[i];
            if(!map.isEmpty() && map.containsKey(rem)){
                // return new int[]{i, map.get(rem)};
                int j = map.get(rem);
                if(i < j){
                    ans[0] = i;
                    ans[1] = j;
                }else{
                    ans[0] = j;
                    ans[1] = i;
                }
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
