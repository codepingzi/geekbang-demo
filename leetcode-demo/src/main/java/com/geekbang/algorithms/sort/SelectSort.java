package com.geekbang.algorithms.sort;

import com.alibaba.fastjson.JSON;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,7,8,2,10,5,6,4,98,89,34,56,9};
        SelectSort test = new SelectSort();
        test.selectSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    private void selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int min = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
