class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Brute force cause O(n^2)
        // The key point is ans[i] = prefix product[i] * postfix product[i]
        // Ex: a[] = [1,2,3,4] => we want ans for ans[2] = (a[0] * a[1]) * a[3]

        int pre = 1, post = 1, n = nums.length;
        int[] ans = new int[n];
        for(int i = 0 ; i < n; i++){
            ans[i] = 1;
        } 

        for(int i = 0 ; i < n; i++){
            ans[i] *= pre;
            pre *= nums[i];

            ans[n - i - 1] *= post;
            post *= nums[n - i - 1];
        } 

        return ans;
    }
}  
