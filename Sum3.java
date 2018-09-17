//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//
//The solution set must not contain duplicate triplets.
//
//Example:
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        Set<List<Integer>> sets = new HashSet<>();
        List<Integer> tmp; 
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2 && nums[i] <= 0; i++) {
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    sets.add(tmp);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(sets);
        
    }
}
