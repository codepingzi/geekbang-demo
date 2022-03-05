package com.geekbang.leetcode.demo;

import com.alibaba.fastjson.JSON;

public class _283_Solution_MoveZeroes {

    public static void main(String[] args) {
        _283_Solution_MoveZeroes test = new _283_Solution_MoveZeroes();
        int[] a = new int[]{1,0,0,2,4,0,9};
        test.moveZeores(a);
        System.out.println(JSON.toJSONString(a));
    }

    /**
     * 双指针
     */
    public void moveZeores(int[] nums){
        int slow = -1;

        for (int i = 0; i <= nums.length - 1; i++){
            if (slow == -1 && nums[i] == 0){
                slow = i;
            }

            if (slow != -1 && nums[i] != 0){
                nums[slow] = nums[i];
                nums[i] = 0;
                slow++;
            }
        }

    }
}
