class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        int[] dp = new int [nums.length - k + 1];
        System.arraycopy(nums, 0, dp, 0, dp.length);
        for(int i=1 ; i<k ; i++){
            dp[0] = Math.max(dp[0],nums[i]);
        }
        for(int j=1; j < nums.length-k+1; j++){
            if(nums[j+k-1] >= dp[j-1]){
                dp[j] = nums[j+k-1];
            } else if(nums[j-1] == dp[j-1]){
                for(int i=j ; i< j+k ; i++){
                    dp[j] = Math.max(dp[j],nums[i]);
                }
            } else if(nums[j-1] != dp[j-1] && nums[j+k-1] < dp[j-1]){
                dp[j] = dp[j-1];
            }
        }
        return dp;
    }
}