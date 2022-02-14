package com.geekbang.leetcode.demo;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _001_Solution_TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,15};
        int target = 6;
        int[] solution01 = new _001_Solution_TwoSum().solution_01(nums, target);
        System.out.println("solution_01 result: " + JSON.toJSONString(solution01));
        int[] solution02 = new _001_Solution_TwoSum().solution_02(nums, target);
        System.out.println("solution_02 result: " + JSON.toJSONString(solution02));

        int[] solution03 = new _001_Solution_TwoSum().solution_03(nums, target);
        System.out.println("solution_03 result: " + JSON.toJSONString(solution03));
    }

    private int[] solution_03(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> numValueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (numValueIndexMap.containsKey(value)){
                return new int[]{i, numValueIndexMap.get(value)};
            }
            numValueIndexMap.put(nums[i], i);
        }

        return null;
    }


    /**
     * HashMap 两次循环
     * 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] solution_02(int[] nums, int target){
        if (null == nums || nums.length == 0){
            return null;
        }

        Map<Integer, Integer> numValueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numValueIndexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int currValue = target - nums[i];
            Integer index = numValueIndexMap.get(currValue);
            if (index != null && i != index){
                return new int[]{i, index};
            }
        }
        return null;
    }


    /**
     * 循环嵌套
     * 时间复杂度O(n²)
     * @param nums
     * @param target
     * @return
     */
    private int[] solution_01(int[] nums, int target){
        if (null == nums || nums.length == 0){
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
