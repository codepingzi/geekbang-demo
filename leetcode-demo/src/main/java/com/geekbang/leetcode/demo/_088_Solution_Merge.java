package com.geekbang.leetcode.demo;

import com.alibaba.fastjson.JSON;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *  
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *  
 *
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangweiping
 * @date 2022/3/1 下午1:21
 */
public class _088_Solution_Merge {

    public static void main(String[] args) {
        int[] num1 = new int[]{0,0,0,0,0};
        int[] num2 = new int[]{1,2,3,4,5};
        int m = 0, n = 5;

        _088_Solution_Merge test = new _088_Solution_Merge();
        test.merge2(num1, m, num2, n);
        System.out.println(JSON.toJSONString(num1));
    }



    private void merge(int[] num1, int m, int[] num2, int n){
        if (n == 0){
            return;
        }

        if (m == 0){
            for (int i = 0; i < n; i++){
                num1[i] = num2[i];
            }
            return;
        }

        int right = 0;
        int leftMax = m - 1;
        for (int i = 0; i < num1.length - 1; i++){
            if (num2[right] < num1[i]){
                int tmpLeftMax = ++leftMax;
                while(tmpLeftMax > i){
                    num1[tmpLeftMax] = num1[tmpLeftMax - 1];
                    tmpLeftMax--;
                }
                num1[i] = num2[right];
                right++;
                if (right == n){
                    break;
                }
            }
        }

        if (n - right > 0){
            for (int i = n - 1, j = 1; i >= right ; i--){
                num1[m + n - j++] = num2[i];
            }
        }
    }

    /**
     * 从后向前比较
     * 由于num1的后面有n个0
     * 比较num1和num2的最后有效位, 较大的放在 m + n -1 位置, 循环
     * 直到两个数组指针都<0 停止
     * @param num1
     * @param m
     * @param num2
     * @param n
     */
    private void merge2(int[] num1, int m, int[] num2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;

        int curr;
        while(p1 >= 0 || p2 >= 0){
            if (p1 == -1){
                curr = num2[p2--];
            }else if(p2 == -1){
                curr =num1[p1--];
            }else if (num1[p1] > num2[p2]){
                curr = num1[p1--];
            }else{
                curr = num2[p2--];
            }
            num1[tail--] = curr;
        }
    }
}
