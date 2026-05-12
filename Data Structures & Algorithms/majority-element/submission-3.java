class Solution {
    public int majorityElement(int[] nums) {
        int[] bits = new int[32];
        int n = nums.length;

        for(int num: nums) {
            for (int i=0; i<32; i++){
                bits[i] += (num>>i)&1;
            }
        }

        int res = 0;
        for (int i=0; i<32; i++) {
            if (bits[i] > n/2) {
                res |= (1<<i);
            }
        }

        return res;
    }
}