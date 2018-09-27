//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Example:
//
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
//Note: Please solve it without division and in O(n).
//
//Follow up:
//Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[nums.length];
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
//            System.out.println(res[i]);    
        }
//        System.out.println("-----------------");
        int tmp = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            tmp *= nums[j + 1];
            res[j] *= tmp;
//            System.out.println(res[j]);
        }
        return res;
    }
}
