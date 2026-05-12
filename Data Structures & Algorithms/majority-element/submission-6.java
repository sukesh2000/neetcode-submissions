class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, num = -1, n = nums.length;
        for (int i=0; i<n; i++) {
            if (count == 0) {
                count=1;
                num = nums[i];
            }
            else if (nums[i] == num) {
                count++;
            }
            else {
                count--;
            }
        }

        count = 0;
        for (int i=0; i<n; i++){
            if(nums[i]==num) {
                count++;
            }
        }

        if(count > n/2)
            return num;
        
        return -1;
    }
}