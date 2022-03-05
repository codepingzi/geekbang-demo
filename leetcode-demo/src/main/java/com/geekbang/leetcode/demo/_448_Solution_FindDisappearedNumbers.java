package com.geekbang.leetcode.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _448_Solution_FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1} ;
        _448_Solution_FindDisappearedNumbers test = new _448_Solution_FindDisappearedNumbers();
        List<Integer> numbers = test.findDisappearedNumbers(a);
        System.out.println(Arrays.toString(numbers.toArray()));
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (Integer num : nums){
            int x = (num - 1) % length;
            nums[x] += length;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < length; i++){
            if(nums[i] <= length){
                ans.add(i + 1);
            }
        }
        return ans;
    }

}
