package com.geekbang.leetcode.demo;

/**
 * @author yangweiping
 * @date 2022/2/28 下午4:01
 */
public class _066_Solution_PlusOne {

    public static void main(String[] args) {


    }

    private int[] plusOne(int[] nums){
        int carry = 0;


        if (nums[nums.length - 1] == 9){
            nums[nums.length - 1] = 0;
            carry = 1;
        }else{
            nums[nums.length - 1] += 1;
        }

        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] + carry > 9){
                nums[i] = 0;
                carry = 1;
            }else{
                nums[i] += carry;
                carry = 0;
                break;
            }
        }

        if (carry > 0){
            int[] newNums = new int[nums.length + 1];
            newNums[0] = 1;
            for (int i = 1; i < newNums.length; i++){
                newNums[i] = nums[i - 1];
            }
            return newNums;
        }else{
            return nums;
        }
    }
}
