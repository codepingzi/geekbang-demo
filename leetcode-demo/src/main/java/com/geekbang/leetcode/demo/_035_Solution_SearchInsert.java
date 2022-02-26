package com.geekbang.leetcode.demo;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _035_Solution_SearchInsert {

    public static void main(String[] args) {


        _035_Solution_SearchInsert test = new _035_Solution_SearchInsert();

        int[] nums = new int[]{1, 2, 3, 4, 5};

        System.out.println(test.searchInsert(nums, 6));
    }

    private int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int middle = left + (right - left) / 2;
            if(target <= nums[middle]){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return left;
    }
}
