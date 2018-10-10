//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//Example 1:
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums[0] <= nums[nums.length - 1]) {
            return search(nums, 0, nums.length - 1, target);
        }
        int index = findIndex(nums, 0, nums.length - 1);
        if (target >= nums[0]) {
            return search(nums, 0, index, target);
        } else {
            return search(nums, index + 1, nums.length - 1, target);
        }
    }
    
    private int findIndex(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return mid;
        } else {
            if (nums[mid] > nums[nums.length - 1]) {
                return findIndex(nums, mid + 1, right);
            } else {
                return findIndex(nums, left, mid);
            }
        }
    }
    
    private int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target){
            return search(nums, left, mid - 1, target);
        } else {
            return search(nums, mid + 1, right, target);
        }
    }
}
