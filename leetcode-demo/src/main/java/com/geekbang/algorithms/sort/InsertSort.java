package com.geekbang.algorithms.sort;

import com.alibaba.fastjson.JSON;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 7, 8, 2, 10, 5, 6, 4, 98, 89, 34, 56, 9};
        InsertSort test = new InsertSort();
        test.sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1] ; j--){
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }
    }
}
