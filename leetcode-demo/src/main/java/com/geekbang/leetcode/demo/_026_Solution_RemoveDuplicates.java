package com.geekbang.leetcode.demo;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 判题标准:
 *
 * 系统会用下面的代码来测试你的题解:
 *
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 *
 * int k = removeDuplicates(nums); // 调用
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _026_Solution_RemoveDuplicates {

    public static void main(String[] args) {
        int[] paramArr = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new _026_Solution_RemoveDuplicates().removeDuplicates_02(paramArr));
        System.out.println(JSON.toJSONString(paramArr));
    }

    /**
     * 迭代方式
     * 1. 顺序比较: 相等记录 duplicateCnt, 不等时:
     * 2.
     * @param nums
     * @return
     */
    private int removeDuplicates_01(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int duplicateCnt = 0;
        int differentNum = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]){
                duplicateCnt += 1;
            }else{
                nums[i - duplicateCnt] = nums[i];
                differentNum++;
            }
        }
        return differentNum;
    }

    /**
     * 双指针
     * 定义两个指针p 前指针, q后指针
     * p = 0, q = 1;
     * 如果nums[p] != nums[q], 将q位的元素移动到p+1位置
     *
     * @param nums
     * @return
     */
    private int removeDuplicates_02(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int p = 0;
        int q = 1;
        while(q < nums.length){
            if (nums[p] != nums[q]){
                if (q - 1 > p){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
