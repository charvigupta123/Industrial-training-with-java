class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1; // Base case: prefix sum of 0 appears once
        
        int prefixSum = 0;
        int result = 0;
        
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            
            // Handle negative remainders in Java
            if (remainder < 0) {
                remainder += k;
            }
            
            result += count[remainder];
            count[remainder]++;
        }
        
        return result;
    }
}